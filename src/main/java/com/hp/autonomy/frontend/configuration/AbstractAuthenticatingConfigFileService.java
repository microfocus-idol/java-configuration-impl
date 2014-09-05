/*
 * Copyright 2013-2014 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.frontend.configuration;

import lombok.extern.slf4j.Slf4j;

/**
 * Reference implementation of {@link ConfigFileService}, which outputs configuration objects as JSON files.
 * An additional type bound is placed on the configuration object this class uses.
 *
 * This class requires that a default config file be available at runtime.
 *
 * Operations on the Config are thread safe.
 *
 * @param <T> The type of the Configuration object. If it extends {@link PasswordsConfig}, passwords will be encrypted
 *           and decrypted when the file is written and read respectively.  A default login will be generated for the
 *           initial config file, and will be removed on subsequent writes.
 *
 */
@Slf4j
public abstract class AbstractAuthenticatingConfigFileService<T extends Config<T> & AuthenticatingConfig<T>> extends BaseConfigFileService<T> {

    @Override
    public T withHashedPasswords(final T config) {
        if(config != null) {
            return config.withHashedPasswords();
        }

        return config;
    }

    @Override
    public T withoutDefaultLogin(final T config) {
        if(config != null) {
            return config.withoutDefaultLogin();
        }

        return config;
    }

    @Override
    public T generateDefaultLogin(final T config) {
        if(config != null) {
            return config.generateDefaultLogin();
        }

        return config;
    }
}
