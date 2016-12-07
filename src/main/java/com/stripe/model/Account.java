package com.stripe.model;

import com.stripe.exception.*;
import com.stripe.net.APIResource;
import com.stripe.net.RequestOptions;

import com.google.gson.annotations.SerializedName;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter @Setter @EqualsAndHashCode(callSuper=false)
public class Account extends APIResource implements HasId, MetadataStore<Account> {
	String id;
	String businessLogo;
	String businessName;
	String businessPrimaryColor;
	@SerializedName("business_url")
	String businessURL;
	Boolean chargesEnabled;
	String country;
	Boolean debitNegativeBalances;
	AccountDeclineChargeOn declineChargeOn;
	String defaultCurrency;
	Boolean detailsSubmitted;
	String displayName;
	String email;
	ExternalAccountCollection externalAccounts;
	Keys keys;
	LegalEntity legalEntity;
	Boolean managed;
	Map<String, String> metadata;
	String productDescription;
	String statementDescriptor;
	String supportEmail;
	String supportPhone;
	@SerializedName("support_url")
	String supportURL;
	String timezone;
	AccountTosAcceptance tosAcceptance;
	AccountTransferSchedule transferSchedule;
	Boolean transfersEnabled;
	Verification verification;

	/**
	 * @deprecated
	 * Use the country_specs endpoint (https://stripe.com/docs/upgrades#2016-03-07)
	 */
	@Deprecated
	List<String> currenciesSupported;

	public static Account create(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return create(params, (RequestOptions) null);
	}

	public static Account create(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.POST, classURL(Account.class), params, Account.class, options);
	}

	public static AccountCollection list(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return list(params, (RequestOptions) null);
	}

	public static AccountCollection list(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return requestCollection(classURL(Account.class), params, AccountCollection.class, options);
	}

	@Deprecated
	public static AccountCollection all(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return list(params, (RequestOptions) null);
	}

	@Deprecated
	public static AccountCollection all(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return list(params, options);
	}

	public static Account retrieve()
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return retrieve((RequestOptions) null);
	}

	/**
	 * In order to preserve backwards-compatibility, this method does two things.
	 * If the parameter looks like an API key (starts with sk_), retrieve the
	 * account resource with no ID parameter set. Otherwise, use the String
	 * parameter as the account ID.
	 */
	@Deprecated
	public static Account retrieve(String apiKeyOrAccountId)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		if (null == apiKeyOrAccountId || apiKeyOrAccountId.startsWith("sk_")) {
			return retrieve(RequestOptions.builder().setApiKey(apiKeyOrAccountId).build());
		} else {
			return retrieve(apiKeyOrAccountId, (RequestOptions) null);
		}
	}

	public static Account retrieve(RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(
			RequestMethod.GET,
			singleClassURL(Account.class),
			null,
			Account.class,
			options);
	}

	public static Account retrieve(String id, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.GET, instanceURL(Account.class, id), null, Account.class, options);
	}

	public Account update(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return update(params, (RequestOptions) null);
	}

	public Account reject(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.POST, instanceURL(Account.class, this.id) + "/reject", params, Account.class, (RequestOptions) null);
	}

	public Account update(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.POST, instanceURL(Account.class, this.id), params, Account.class, options);
	}

	public DeletedAccount delete(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return delete(params, (RequestOptions) null);
	}

	public DeletedAccount delete(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.DELETE, instanceURL(Account.class, this.id), params, DeletedAccount.class, options);
	}

	@Getter @Setter @EqualsAndHashCode(callSuper=false)
	public static class Verification extends StripeObject {
		Boolean contacted;
		String disabledReason;
		Long dueBy;
		List<String> fieldsNeeded;
	}

	@Getter @Setter @EqualsAndHashCode(callSuper=false)
	public static class Keys extends StripeObject {
		String publishable;
		String secret;
	}
}
