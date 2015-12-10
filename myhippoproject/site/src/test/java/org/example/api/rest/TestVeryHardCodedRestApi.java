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
package org.example.api.rest;

import javax.jcr.Session;

import com.jayway.restassured.specification.RequestSender;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.onehippo.cms7.services.HippoServiceRegistry;
import org.onehippo.cms7.services.search.jcr.service.HippoJcrSearchService;
import org.onehippo.cms7.services.search.service.QueryPersistService;
import org.onehippo.cms7.services.search.service.SearchService;
import org.onehippo.cms7.services.search.service.SearchServiceException;
import org.onehippo.cms7.services.search.service.SearchServiceFactory;
import org.onehippo.jaxrs.cxf.CXFTest;
import org.onehippo.repository.testutils.RepositoryTestCase;

import static org.hamcrest.core.IsEqual.equalTo;

public class TestVeryHardCodedRestApi extends RepositoryTestCase {

    static class CXFTestHelper extends CXFTest {
        private Session session;

        public CXFTestHelper(Session session) {
            this.session = session;
        }

        void setup() {
            VeryHardCodedRestApi api = new VeryHardCodedRestApi();
            api.setSession(session);
            setup(api);
        }

        void teardown() {
            tearDownBackend();
        }

        public RequestSender when() {
            return super.when();
        }
    }

    private CXFTestHelper cxfTestHelper;

    @Before
    final public void setupTestVeryHardCodedRestApi() {
        cxfTestHelper = new CXFTestHelper(session);
        cxfTestHelper.setup();
    }

    @After
    final public void teardownTestVeryHardCodedRestApi() {
        cxfTestHelper.tearDownBackend();
    }

    // copy from com.onehippo.cms7.search.frontend.engine.model.QueryResultModelTest
    // this needs to go into a helper class as well
    private SearchServiceFactory searchServiceFactory;

    private SearchServiceFactory createSearchServiceFactory() {
        return new SearchServiceFactory() {
            private HippoJcrSearchService createService() {
                final HippoJcrSearchService searchService = new HippoJcrSearchService();
                searchService.setSession(session);
                return searchService;
            }

            @Override
            public SearchService createSearchService(final Object clientObject) throws SearchServiceException {
                return createService();
            }

            @Override
            public QueryPersistService createQueryPersistService(final Object clientObject) throws SearchServiceException {
                return createService();
            }
        };
    }

    @Before
    public void registerSearchServiceFactory() {
        searchServiceFactory = createSearchServiceFactory();
        HippoServiceRegistry.registerService(searchServiceFactory, SearchServiceFactory.class, Session.class.getName());
    }

    @After
    public void unregisterSearchServiceFactory() {
        HippoServiceRegistry.unregisterService(searchServiceFactory, SearchServiceFactory.class, Session.class.getName());
    }
    // end copy

    @Test
    public void test_getDocuments() {
        cxfTestHelper.when()
                .get("/content/documents")
        .then()
                .statusCode(200)
                .body("count", equalTo("4"));
    }

    @Test
    public void test_getContentByPath() {
        cxfTestHelper.when()
                .get("/content/[path]")
        .then()
                .statusCode(200)
                .body("method", equalTo("getContentByPath(path)"));
    }

    @Ignore
    @Test
    public void test_getContentByPathWithSlashes() {
        cxfTestHelper.when()
                .get("/content/[/this/that/path]")
        .then()
                .statusCode(200)
                .body("method", equalTo("getContentByPath(/this/that/path)"));
    }

}
