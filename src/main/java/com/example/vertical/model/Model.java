package com.example.vertical.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "models")
public class Model {
    public Model(String modelHeader, String modelPath, String modelDescription) {
        this.modelHeader = modelHeader;
        this.modelPath = modelPath;
        this.modelDescription = modelDescription;

    }
    @Id
    private String id;
    String modelHeader;
    String modelPath;
    String modelDescription;

    public String getModelHeader() {
        return modelHeader;
    }

    public void setModelHeader(String modelHeader) {
        this.modelHeader = modelHeader;
    }

    public String getModelPath() {
        return modelPath;
    }

    public void setModelPath(String modelPath) {
        this.modelPath = modelPath;
    }

    public String getModelDescription() {
        return modelDescription;
    }

    public void setModelDescription(String modelDescription) {
        this.modelDescription = modelDescription;
    }



}