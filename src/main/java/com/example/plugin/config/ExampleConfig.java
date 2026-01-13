package com.example.plugin.config;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;

// Saved under: plugins/com.example_ExamplePlugin/ExamplePlugin.example.json
public class ExampleConfig {
    // Codec for serializing and deserializing the ExampleConfig class.
    public static final BuilderCodec<ExampleConfig> CODEC = BuilderCodec
            .builder(ExampleConfig.class, ExampleConfig::new)
            .append(new KeyedCodec<String>("Text", Codec.STRING),
                    (config, value, exinfotraInfo) -> config.text = value, // Setter
                    (config, info) -> config.text)// Getter
            .add()
            .append(new KeyedCodec<Boolean>("Bool", Codec.BOOLEAN),
                    (config, value, info) -> config.bool = value, // Setter
                    (config, info) -> config.bool) // Getter
            .add()
            .append(new KeyedCodec<Integer>("Number", Codec.INTEGER),
                    (config, value, info) -> config.number = value, // Setter
                    (config, info) -> config.number) // Getter
            .add()
            .build();

    // Configuration fields.
    private String text = "Welcome to the server!";
    private boolean bool = true;
    private int number = 100;

    // Default empty constructor.
    public ExampleConfig() {
    }

    // Getters for the configuration fields.
    public String getText() {
        return text;
    }

    public boolean isBool() {
        return bool;
    }

    public int getNumber() {
        return number;
    }
}
