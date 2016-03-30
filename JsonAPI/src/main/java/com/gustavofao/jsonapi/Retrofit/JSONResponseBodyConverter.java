package com.gustavofao.jsonapi.Retrofit;

import com.gustavofao.jsonapi.JSONApiConverter;

import java.io.BufferedReader;
import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class JSONResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private JSONApiConverter converter;

    public JSONResponseBodyConverter(JSONApiConverter converter) {
        this.converter = converter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(value.charStream());
            StringBuilder builder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            return (T) converter.fromJson(builder.toString());
        } finally {
            value.charStream().close();
        }
    }
}
