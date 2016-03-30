package com.gustavofao.jsonapi.Retrofit;

import com.gustavofao.jsonapi.JSONApiConverter;
import com.gustavofao.jsonapi.Models.Resource;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class JSONConverterFactory extends Converter.Factory {

    private JSONApiConverter jsonApiConverter;

    public static JSONConverterFactory create(JSONApiConverter jsonApiConverter) {
        return new JSONConverterFactory(jsonApiConverter);
    }

    public static JSONConverterFactory create(Class<? extends Resource>... classes) {
        return new JSONConverterFactory(new JSONApiConverter(classes));
    }

    private JSONConverterFactory(JSONApiConverter jsonApiConverter) {
        this.jsonApiConverter = jsonApiConverter;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
        return new JSONResponseBodyConverter<>(jsonApiConverter);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations,
                                                          Annotation[] methodAnnotations, Retrofit retrofit) {
        return new JSONRequestBodyConverter<>(jsonApiConverter);
    }

}
