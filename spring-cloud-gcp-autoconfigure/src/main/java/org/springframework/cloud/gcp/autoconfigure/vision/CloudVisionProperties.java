/*
 * Copyright 2017-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.gcp.autoconfigure.vision;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.cloud.gcp.core.Credentials;
import org.springframework.cloud.gcp.core.CredentialsSupplier;
import org.springframework.cloud.gcp.core.GcpScope;

/**
 * Additional settings for use with Cloud Vision APIs.
 *
 * @author Daniel Zou
 * @since 1.1
 */
@ConfigurationProperties("spring.cloud.gcp.vision")
public class CloudVisionProperties implements CredentialsSupplier {

	// Overrides the GCP OAuth2 credentials specified in the Core module.
	@NestedConfigurationProperty
	private final Credentials credentials = new Credentials(GcpScope.CLOUD_VISION.getUrl());

	/**
	 * Number of threads used to poll for the completion of Document OCR operations.
	 */
	private int executorThreadsCount = 1;

	/**
	 * Number of document pages to include in each JSON output file.
	 */
	private int jsonOutputBatchSize = 20;

	public Credentials getCredentials() {
		return this.credentials;
	}

	public int getExecutorThreadsCount() {
		return executorThreadsCount;
	}

	public void setExecutorThreadsCount(int executorThreadsCount) {
		this.executorThreadsCount = executorThreadsCount;
	}

	public int getJsonOutputBatchSize() {
		return jsonOutputBatchSize;
	}

	public void setJsonOutputBatchSize(int jsonOutputBatchSize) {
		this.jsonOutputBatchSize = jsonOutputBatchSize;
	}
}
