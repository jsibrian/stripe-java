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

import java.util.HashMap;
import java.util.Map;

@Getter @Setter @EqualsAndHashCode(callSuper=false)
public class Customer extends APIResource implements MetadataStore<Customer>, HasId {
	String id;
	Long accountBalance;
	String businessVatId;
	Long created;
	String currency;
	String defaultSource;
	Boolean deleted;
	Boolean delinquent;
	String description;
	Discount discount;
	String email;
	Boolean livemode;
	Map<String, String> metadata;
	ShippingDetails shipping;
	ExternalAccountCollection sources;
	CustomerSubscriptionCollection subscriptions;

	/**
	 * @deprecated
	 * Use `sources` field (https://stripe.com/docs/upgrades#2015-02-18)
	 */
	@Deprecated
	CustomerCardCollection cards;

	/**
	 * @deprecated
	 * Use `default_source` field (https://stripe.com/docs/upgrades#2015-02-18)
	 */
	@Deprecated
	String defaultCard;

	/**
	 * @deprecated
	 * Use the upcoming invoice endpoint (https://stripe.com/docs/upgrades#2012-03-25)
	 */
	@Deprecated
	NextRecurringCharge nextRecurringCharge;

	/**
	 * @deprecated
	 * Use `subscriptions` field (https://stripe.com/docs/upgrades#2014-01-31)
	 */
	@Deprecated
	Subscription subscription;

	/**
	 * @deprecated
	 * Use `subscriptions` field (https://stripe.com/docs/upgrades#2014-01-31)
	 */
	@Deprecated
	Long trialEnd;

	public static Customer create(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return create(params, (RequestOptions) null);
	}

	public static Customer retrieve(String id) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return retrieve(id, (RequestOptions) null);
	}

	public Customer update(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return update(params, (RequestOptions) null);
	}

	public DeletedCustomer delete() throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return delete((RequestOptions) null);
	}

	public Card createCard(String token) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return createCard(token, (RequestOptions) null);
	}

	public Card createCard(Map<String, Object> params) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return createCard(params, (RequestOptions) null);
	}

	// Use `(BankAccount)customer.getSources().create(params)` instead.
	@Deprecated
	public BankAccount createBankAccount(String token) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return createBankAccount(token, (RequestOptions) null);
	}

	@Deprecated
	public BankAccount createBankAccount(String token, RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		Map<String, Object> postParams = new HashMap<String, Object>();
		postParams.put("bank_account", token);

		return createBankAccount(postParams, options);
	}

	@Deprecated
	public BankAccount createBankAccount(Map<String, Object> params) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return createBankAccount(params, (RequestOptions) null);
	}

	@Deprecated
	public BankAccount createBankAccount(Map<String, Object> params, RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return request(RequestMethod.POST, String.format("%s/bank_accounts",
				instanceURL(Customer.class, this.id)), params, BankAccount.class, options);
	}

	public Subscription createSubscription(Map<String, Object> params) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return createSubscription(params, (RequestOptions) null);
	}

	/** 1/2014: Legacy (from before multiple subscriptions per customer) */
	public Subscription updateSubscription(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return updateSubscription(params, (RequestOptions) null);
	}

	/** 1/2014: Legacy (from before multiple subscriptions per customer) */
	public Subscription cancelSubscription() throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return cancelSubscription(null, (RequestOptions) null);
	}

	/** 1/2014: Legacy (from before multiple subscriptions per customer) */
	public Subscription cancelSubscription(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return cancelSubscription(params, (RequestOptions) null);
	}

	public void deleteDiscount() throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		deleteDiscount((RequestOptions) null);
	}

	@Deprecated
	public static Customer create(Map<String, Object> params, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return create(params, RequestOptions.builder().setApiKey(apiKey).build());
	}
	public static Customer create(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.POST, classURL(Customer.class), params, Customer.class, options);
	}

	@Deprecated
	public static Customer retrieve(String id, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return retrieve(id, RequestOptions.builder().setApiKey(apiKey).build());
	}
	public static Customer retrieve(String id, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.GET, instanceURL(Customer.class, id), null, Customer.class, options);
	}

	public static CustomerCollection list(Map<String, Object> params)
			throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return list(params, (RequestOptions) null);
	}

	public static CustomerCollection list(Map<String, Object> params,
			RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return requestCollection(classURL(Customer.class), params, CustomerCollection.class, options);
	}

	@Deprecated
	public static CustomerCollection all(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return list(params, (RequestOptions) null);
	}

	@Deprecated
	public static CustomerCollection all(Map<String, Object> params,
			String apiKey) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return list(params, RequestOptions.builder().setApiKey(apiKey).build());
	}

	@Deprecated
	public static CustomerCollection all(Map<String, Object> params,
			RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return list(params, options);
	}

	@Deprecated
	public Customer update(Map<String, Object> params, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return update(params, RequestOptions.builder().setApiKey(apiKey).build());
	}
	public Customer update(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.POST, instanceURL(Customer.class, this.id), params, Customer.class, options);
	}

	@Deprecated
	public DeletedCustomer delete(String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		RequestOptions result = null;
		return delete(RequestOptions.builder().setApiKey(apiKey).build());
	}
	public DeletedCustomer delete(RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.DELETE, instanceURL(Customer.class, this.id), null, DeletedCustomer.class, options);
	}

	// Use `(Card)customer.getSources().create(params)` instead.
	@Deprecated
	public Card createCard(String token, String apiKey) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return createCard(token, RequestOptions.builder().setApiKey(apiKey).build());
	}

	@Deprecated
	public Card createCard(String token, RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		Map<String, Object> postParams = new HashMap<String, Object>();
		postParams.put("card", token);

		return createCard(postParams, options);
	}

	@Deprecated
	public Card createCard(Map<String, Object> params, String apiKey) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return createCard(params, RequestOptions.builder().setApiKey(apiKey).build());
	}

	@Deprecated
	public Card createCard(Map<String, Object> params, RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return request(RequestMethod.POST, String.format("%s/cards",
						instanceURL(Customer.class, this.id)), params, Card.class, options);
	}

	@Deprecated
	public Subscription createSubscription(Map<String, Object> params, String apiKey) throws AuthenticationException,
		InvalidRequestException, APIConnectionException, CardException,
		APIException {
		return createSubscription(params, RequestOptions.builder().setApiKey(apiKey).build());
	}
	public Subscription createSubscription(Map<String, Object> params, RequestOptions options) throws AuthenticationException,
		InvalidRequestException, APIConnectionException, CardException,
		APIException {
		return request(RequestMethod.POST, String.format("%s/subscriptions",
						instanceURL(Customer.class, this.id)), params, Subscription.class, options);
	}

	/** 1/2014: Legacy (from before multiple subscriptions per customer) */
	@Deprecated
	public Subscription updateSubscription(Map<String, Object> params,
			String apiKey) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return updateSubscription(params, RequestOptions.builder().setApiKey(apiKey).build());
	}
	/** 1/2014: Legacy (from before multiple subscriptions per customer) */
	public Subscription updateSubscription(Map<String, Object> params,
			RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return request(RequestMethod.POST, String.format("%s/subscription",
						instanceURL(Customer.class, this.id)), params, Subscription.class, options);
	}

	/** 1/2014: Legacy (from before multiple subscriptions per customer) */
	@Deprecated
	public Subscription cancelSubscription(String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return cancelSubscription(RequestOptions.builder().setApiKey(apiKey).build());
	}
	public Subscription cancelSubscription(RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return cancelSubscription(null, options);
	}

	/** 1/2014: Legacy (from before multiple subscriptions per customer) */
	@Deprecated
	public Subscription cancelSubscription(Map<String, Object> params,
			String apiKey) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return cancelSubscription(params, RequestOptions.builder().setApiKey(apiKey).build());
	}
	public Subscription cancelSubscription(Map<String, Object> params,
			RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return request(RequestMethod.DELETE, String.format("%s/subscription",
						instanceURL(Customer.class, this.id)), params, Subscription.class, options);
	}

	@Deprecated
	public void deleteDiscount(String apiKey) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		deleteDiscount(RequestOptions.builder().setApiKey(apiKey).build());
	}
	public void deleteDiscount(RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		request(RequestMethod.DELETE, String.format("%s/discount",
						instanceURL(Customer.class, this.id)), null, Discount.class, options);
	}

}
