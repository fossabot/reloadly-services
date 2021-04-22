/*
 * Copyright (C) 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.reloadly.auth.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

    @JsonProperty("error")
    private final String error;

    @JsonProperty("error_description")
    private final String errorDescription;

    @JsonProperty("error_detail")
    private final String errorDetail;

    @JsonCreator
    public ErrorResponse(String error, String errorDescription, String errorDetail) {
        this.error = error;
        this.errorDescription = errorDescription;
        this.errorDetail = errorDetail;
    }

    public String getError() {
        return error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "error='" + error + '\'' +
                ", errorDescription='" + errorDescription + '\'' +
                ", errorDetail='" + errorDetail + '\'' +
                '}';
    }
}