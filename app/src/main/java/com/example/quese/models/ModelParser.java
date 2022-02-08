package com.example.quese.models;

import java.util.ArrayList;

public class ModelParser extends ArrayList<ModelParser> {
    GameGenerator parser;

    public ModelParser(GameGenerator parser) {
        this.parser = parser;
    }

    public GameGenerator getParser() {
        return parser;
    }

    public void setParser(GameGenerator parser) {
        this.parser = parser;
    }
}
