JSONApi [![Download](https://api.bintray.com/packages/faogustavo/maven/JSONApi/images/download.svg)](https://bintray.com/faogustavo/maven/JSONApi/_latestVersion) [![License](https://img.shields.io/hexpm/l/plug.svg)]() [![MinSDK](https://img.shields.io/badge/minSdk-15-brightgreen.svg)]()
=================================================================================================================================================================

A simple way to implement JSONApi specifications to convert Models to Json and Json to Models.

## INSTALL
Add this dependecy from jCenter:

```gradle
compile 'com.gustavofao:JSONApi:1.0.6@aar'
```

If the installation fails, add this line to your gradle top level:

```gradle
maven { url "http://dl.bintray.com/faogustavo/maven" }
```

## USAGE
The first step to use the library is to initiate the deserializer with your classes.
To show how it works, we will use the default JSON that is on jsonapi.org homepage and on [raw folder](/app/src/main/res/raw/data.json).

### FIRST STEP - *Create your models*
All models to be conveted need to have two things.
* It need to inherit from [Resource](/JsonAPI/src/main/java/com/gustavofao/jsonapi/Models/Resource.java)
* It need to have the [Type](/JsonAPI/src/main/java/com/gustavofao/jsonapi/Annotations/Type.java) annotation on your class.

```java
import com.gustavofao.jsonapi.Annotatios.Type;
import com.gustavofao.jsonapi.Models.Resource;

@Type("comments")
public class Comment extends Resource {

    private String body;
    private Person author;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Person getPerson() {
        return author;
    }

    public void setPerson(Person author) {
        this.author = author;
    }
}
```

### SECOND STEP - *Instantiate the JSONApiConverter*
The JSONApiConverter have to be instantiated with all your models.

```java
JSONApiConverter api = new JSONApiConverter(Article.class, Comment.class, Person.class);
```

### THIRD STEP - *Serialize or deserialize*

#### SERIALIZE INTO JSON
To serialize one object, it have to be an instance or inherit from Resource and have to be passed as parameter to *toJson*.
The return will be a String with the JSON.

```java
Article article = new Article();

//
//       SET VALUES HERE
//

String jsonValue = api.toJson(article);
```

> **WARNING**
> LINKS FIELDS ARE NOT GOING TO BE SERIALIZED. I'M WORKING ON IT FOR THE NEXT VERSION.

#### DESERIALIZE FROM JSON
To deserialize the JSON, you have to pass it as parameter for *fromJson* method.
The return will be an JSONApiObject.

```java
JSONApiObject obj = api.fromJson(json);
if (obj.getData().size() > 0) {
    //Success   
    if (obj.getData().size() == 1) {
        //Single Object  
        Article article = (Article) obj.getData(0);
    } else {
        //List of Objects
        List<Resource> resources = obj.getData();
    }
} else {
    //Error or empty data
}
```

> **WARNING**
> DATA WILL ALWAYS COME AS LIST. YOU HAVE TO VERIFY IF THERE IS ONLY ONE OR MORE. I'M WORKING ON IT TOO.

### TIPS
#### ONE-TO-MANY RELATION
To handle with one-to-many relation, you have to use [JSONList](/JsonAPI/src/main/java/com/gustavofao/jsonapi/Models/JSONList.java) with the type of the Object.
Example below.

#### CHANGE SERIALIZATION NAME
To change the name of the object on the JSON, you can use the Annotation [SerialName](/JsonAPI/src/main/java/com/gustavofao/jsonapi/Annotations/SerialName.java) on your field.
Example below.

#### IGNORE FIELDS
To ignore fields of the model, you have to use the Annotation [Excluded](/JsonAPI/src/main/java/com/gustavofao/jsonapi/Annotations/Excluded.java) on your field.
Example below.

```java
import com.gustavofao.jsonapi.Annotatios.Excluded;
import com.gustavofao.jsonapi.Annotatios.SerialName;
import com.gustavofao.jsonapi.Annotatios.Type;
import com.gustavofao.jsonapi.Models.JSONList;
import com.gustavofao.jsonapi.Models.Resource;

@Type("articles")
public class Article extends Resource {

    private String title;
    private JSONList<Comment> comments;

    @Excluded
    private String blah;

    @SerialName("author")
    private Person person;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public JSONList<Comment> getComments() {
        return comments;
    }

    public void setComments(JSONList<Comment> comments) {
        this.comments = comments;
    }
}

```

#### MULTIPLE TYPE TO SAME OBJECT
When you have different types for the same object you can use the annotation @Types(String[] value).

```java
@Types({"test", "test02"})
```

### Retrofit
The library has integration with Retrofit.
To use you have to pass the JSONConverterFactory as converterFactory and

```java
Retrofit retrofit = new Retrofit.Builder()
    .addConverterFactory(JSONConverterFactory.create(Article.class, Comment.class, Person.class))
    .baseUrl(url)
    .build();
```

All requests have to be with parameter from server **JSONApiObject**.

```java
Call<JSONApiObject> obj = service.testRequest();
obj.enqueue(new Callback<JSONApiObject>() {
    @Override
    public void onResponse(Call<JSONApiObject> call, Response<JSONApiObject> response) {
        if (response.body() != null) {
            if (response.body().getData().size() > 0) {
                Toast.makeText(MainActivity.this, "Object With data", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "No Items", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Empty Body", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<JSONApiObject> call, Throwable t) {
        Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
    }
});
```

## Thanks
[AceleraMEI](http://www.aceleramei.com.br/) for suport the development.

## License
    Copyright 2016 Gustavo Fão. All rights reserved.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
