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

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Produces("application/json")
public class VeryHardCodedRestApi {

    @GET
    @Path("/content/documents")
    public Response getDocuments() {
        return Response.status(500).entity("{\"message\":\"TODO - another TODO is to agree on error response guidelines\"}").build();
    }

    @GET
    @Path("/content/documents/{uuid}")
    public Response getDocumentsByUUID(@PathParam("uuid") String uuid) {
        return Response.status(500).entity("{\"message\":\"TODO - another TODO is to agree on error response guidelines\"}").build();
    }

    @GET
    @Path("/content/myhippoproject:news")
    public Response getNews() {
        return Response.status(500).entity("{\"message\":\"TODO - another TODO is to agree on error response guidelines\"}").build();
    }

    @GET
    @Path("/content/myhippoproject:news/{uuid}")
    public Response getNewsByUUID(@PathParam("uuid") String uuid) {
        return Response.status(500).entity("{\"message\":\"TODO - another TODO is to agree on error response guidelines\"}").build();
    }

    @GET
    @Path("/content/myhippoproject:events")
    public Response getEvents() {
        return Response.status(500).entity("{\"message\":\"TODO - another TODO is to agree on error response guidelines\"}").build();
    }

    @GET
    @Path("/content/myhippoproject:events/{uuid}")
    public Response getEventsByUUID(@PathParam("uuid") String uuid) {
        return Response.status(500).entity("{\"message\":\"TODO - another TODO is to agree on error response guidelines\"}").build();
    }

    @GET
    @Path("/types")
    public Response getTypes() {
        return Response.status(500).entity("{\"message\":\"TODO - another TODO is to agree on error response guidelines\"}").build();
    }

    @GET
    @Path("/types/{name}")
    public Response getTypesByName(@PathParam("name") String name) {
        return Response.status(500).entity("{\"message\":\"TODO - another TODO is to agree on error response guidelines\"}").build();
    }

    @GET
    @Path("/content/[{path}]")
    public Response getContentByPath(@PathParam("path") String path) {
        return Response.status(200).entity("{\"method\":\"getContentByPath(" + path + ")\"}").build();
    }

}
