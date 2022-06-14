package com.sap.mobile.services.client.push;

import org.springframework.http.client.ClientHttpRequestInterceptor;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter(AccessLevel.PACKAGE)
@SuperBuilder
class ServiceKeyClientConfiguration extends ClientConfiguration {
	private MobileServicesSettings.ServiceKey serviceKey;

	@Override
	String getRootUri() {
		return serviceKey.getUrl();
	}

	@Override
	ClientHttpRequestInterceptor getAuthInterceptor() {
		return new ApiKeyAuthorizationRequestInterceptor(this.serviceKey);
	}

}