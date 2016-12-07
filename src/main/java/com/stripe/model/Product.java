package com.stripe.model;

import java.util.List;
import java.util.Map;

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

@Getter @Setter @EqualsAndHashCode(callSuper=false)
public class Product extends APIResource implements HasId, MetadataStore<Product> {
	String id;
	Boolean active;
	List<String> attributes;
	String caption;
	Long created;
	List<String> deactivateOn;
	String description;
	List<String> images;
	Boolean livemode;
	Map<String, String> metadata;
	String name;
	PackageDimensions packageDimensions;
	Boolean shippable;
	SKUCollection skus;
	Long updated;
	String url;

	public static Product create(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return create(params, (RequestOptions) null);
	}

	public static Product retrieve(String id)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return retrieve(id, (RequestOptions) null);
	}

	public Product update(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return update(params, (RequestOptions) null);
	}

	public static Product create(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.POST, classURL(Product.class), params, Product.class, options);
	}

	public static Product retrieve(String id, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.GET, instanceURL(Product.class, id), null, Product.class, options);
	}

	public DeletedProduct delete()
		throws AuthenticationException, InvalidRequestException,
		APIConnectionException, CardException, APIException {
		return delete((RequestOptions) null);
	}

	public DeletedProduct delete(RequestOptions options)
		throws AuthenticationException, InvalidRequestException,
		APIConnectionException, CardException, APIException {
		return request(RequestMethod.DELETE, instanceURL(Product.class, this.id), null, DeletedProduct.class, options);
	}

	public static ProductCollection list(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return list(params, (RequestOptions) null);
	}

	public static ProductCollection list(Map<String, Object> params,
			RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return requestCollection(classURL(Product.class), params, ProductCollection.class, options);
	}

	@Deprecated
	public static ProductCollection all(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return list(params, (RequestOptions) null);
	}

	@Deprecated
	public static ProductCollection all(Map<String, Object> params,
			RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return list(params, options);
	}

	public Product update(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.POST, instanceURL(Product.class, this.id), params, Product.class, options);
	}
}
