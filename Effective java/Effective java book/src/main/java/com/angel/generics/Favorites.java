package com.angel.generics;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Favorites {
    // Typesafe heterogeneous container pattern - implementation

        private Map<Class<?>, Object> favorites = new HashMap<>();
        public <T> void putFavorite(Class<T> type, T instance) {
            favorites.put(Objects.requireNonNull(type), instance);
        }
        public <T> T getFavorite(Class<T> type) { return type.cast(favorites.get(type));
        }
//    There are a few subtle things going on here. Each Favorites instance is backed by a private Map<Class<?>, Object> called favorites.
//    You might think that you couldn’t put anything into this Map because of the unbounded wildcard type, but the truth is quite the opposite.
//    The thing to notice is that the wildcard type is nested: it’s not the type of the map that’s a wildcard type but the type of its key.
//    This means that every key can have a different parameterized type: one can be Class<String>, the next Class<Integer>, and so on.
//    That’s where the heterogeneity comes from.
//    The next thing to notice is that the value type of the favorites Map is simply Object.
//    In other words, the Map does not guarantee the type relationship between keys and values, which is that every value is of the type represented by its key.
//    In fact, Java’s type system is not powerful enough to express this. But we know that it’s true, and we take advantage of it when the time comes to retrieve a favorite.

}
