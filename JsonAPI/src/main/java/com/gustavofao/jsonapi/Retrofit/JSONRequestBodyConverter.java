package com.gustavofao.jsonapi.Retrofit;

import com.gustavofao.jsonapi.JSONApiConverter;
import com.gustavofao.jsonapi.Models.Resource;

import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

public class JSONRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

    private JSONApiConverter converter;

    public JSONRequestBodyConverter(JSONApiConverter converter) {
        this.converter = converter;
    }

    @Override
    public RequestBody convert(T value) throws IOException {
        if (value instanceof Resource)
            return RequestBody.create(MEDIA_TYPE, converter.toJson((Resource) value));
        return RequestBody.create(MEDIA_TYPE, converter.toJson((List<Resource>) value));
    }
}
