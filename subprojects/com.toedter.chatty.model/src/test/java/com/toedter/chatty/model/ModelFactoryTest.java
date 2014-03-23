/**
 * Copyright (c) 2014 Kai Toedter
 * All rights reserved.
 * Licensed under MIT License, see http://toedter.mit-license.org/
 */

package com.toedter.chatty.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;

public class ModelFactoryTest {

    private ModelFactory modelFactory;

    @Before
    public void before() {
        modelFactory = ModelFactory.getInstance();
    }

    @Test
    public void should_get_instance() {
        assertThat(modelFactory, notNullValue());
    }

    @Test
    public void should_get_user_repository() {
        UserRepository userRepository = modelFactory.getUserRepository();
        assertThat(userRepository, notNullValue());
    }

    @Test
    public void should_initialize_user_repository_with_test_data() {
        modelFactory.initTestData();
        UserRepository userRepository = modelFactory.getUserRepository();

        assertThat(userRepository.getSize(), greaterThan(3L));
    }
}
