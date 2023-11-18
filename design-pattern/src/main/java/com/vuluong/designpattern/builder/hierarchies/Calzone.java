package com.vuluong.designpattern.builder.hierarchies;

public class Calzone extends Pizza {

    private final boolean sauceInside;

    Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false; // default

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        public Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
