package com.stripe.model;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource;
import com.stripe.net.RequestOptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter @Setter @EqualsAndHashCode(callSuper=false)
public class CountrySpec extends APIResource implements HasId {
	String id;
	String defaultCurrency;
	Map<String, List<String>> supportedBankAccountCurrencies;
	List<String> supportedPaymentCurrencies;
	List<String> supportedPaymentMethods;
	VerificationFields verificationFields;

	public static CountrySpec retrieve(String country) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return retrieve(country, (RequestOptions) null);
	}

	public static CountrySpec retrieve(String country, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(
			RequestMethod.GET,
			instanceURL(CountrySpec.class, country),
			null,
			CountrySpec.class,
			options);
	}

	public static CountrySpecCollection list(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return list(params, (RequestOptions) null);
	}

	public static CountrySpecCollection list(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return requestCollection(classURL(CountrySpec.class), params, CountrySpecCollection.class, options);
	}
}
