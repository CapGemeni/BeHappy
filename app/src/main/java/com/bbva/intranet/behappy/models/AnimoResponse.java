package com.bbva.intranet.behappy.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Martin Vega on 09/03/2018.
 */

public class AnimoResponse {

    @SerializedName("data")
    private List<Data> data;
    @SerializedName("message")
    private String message;
    @SerializedName("code")
    private String code;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class Data {
        @SerializedName("actualizado")
        private String actualizado;
        @SerializedName("captudado")
        private String captudado;
        @SerializedName("id")
        private int id;
        @SerializedName("emoji")
        private String emoji;
        @SerializedName("descripcion")
        private String descripcion;

        public String getActualizado() {
            return actualizado;
        }

        public void setActualizado(String actualizado) {
            this.actualizado = actualizado;
        }

        public String getCaptudado() {
            return captudado;
        }

        public void setCaptudado(String captudado) {
            this.captudado = captudado;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEmoji() {
            return emoji;
        }

        public void setEmoji(String emoji) {
            this.emoji = emoji;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
    }
}
