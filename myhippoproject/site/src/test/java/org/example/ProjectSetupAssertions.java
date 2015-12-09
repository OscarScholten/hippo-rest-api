/*
 *  Copyright 2015 Hippo B.V. (http://www.onehippo.com)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.example;

import javax.jcr.Node;

import org.junit.Test;
import org.onehippo.repository.testutils.RepositoryTestCase;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * This class contains a few tests that validate that the project is set up in such a way that it is possible to
 * create an automated integration test. Steps for such an integration test are:
 * <ul>
 *     <li>create a new Hippo project from the archetype</li>
 *     <li>start essentials, add the "news" and "events" features, validate the content is loaded ({@link #test_bootstrap_content_is_loaded()}</li>
 *     <li>enable the REST API, validate that the content is there ({@link #test_rest_api_is_loaded()})</li>
 *     <li>update the document types - steps TODO, validate that the content is updated ({@link #test_rest_api_is_updated_after_model_changes()})</li>
 * </ul>
 */
public class ProjectSetupAssertions extends RepositoryTestCase {

    @Test
    public void test_bootstrap_content_is_loaded() throws Exception {
        // TODO: create a mechanism to guess the "2015/15" part
        Node node = session.getNode("/content/documents/myhippoproject/news/2015/12/the-medusa-news");

        assertNotNull(node);
    }

    @Test
    public void test_rest_api_is_loaded() {
        /* Steps:
         * - could be as simple as using RESTassured to fetch the list of docs
         * - then fetch the medusa doc and validate the author
         */
        fail();
    }

    @Test
    public void test_rest_api_is_updated_after_model_changes() {
        /* Steps:
         * - update content model somehow, probably by loading additional bootstrap content
         * - add content to existing docs
         * - validate that the REST output contains the added content
         */
        fail();
    }

}
