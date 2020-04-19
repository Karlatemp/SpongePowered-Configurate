/*
 * Configurate
 * Copyright (C) zml and Configurate contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.spongepowered.configurate.objectmapping.serialize;

import com.google.common.reflect.TypeToken;
import org.spongepowered.configurate.objectmapping.ObjectMappingException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.function.Predicate;

final class URISerializer extends ScalarSerializer<URI> {
    URISerializer() {
        super(URI.class);
    }

    @Override
    public URI deserialize(TypeToken<?> type, Object obj) throws ObjectMappingException {
        final String plainUri = obj.toString();
        try {
            return new URI(plainUri);
        } catch (URISyntaxException e) {
            throw new CoercionFailedException(obj, "URI");
        }
    }

    @Override
    public Object serialize(URI item, Predicate<Class<?>> typeSupported) {
        return item.toString();
    }
}
