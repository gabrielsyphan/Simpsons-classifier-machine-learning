package com.syphan.mlsimpsonsclassifier.model;

public class ExtractDataDto {

    private float[] dataColected;
    private String character;

    public ExtractDataDto() {
    }

    public ExtractDataDto(float[] dataColected, String character) {
        this.dataColected = dataColected;
        this.character = character;
    }

    public float[] getDataColected() {
        return dataColected;
    }

    public void setDataColected(float[] dataColected) {
        this.dataColected = dataColected;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
