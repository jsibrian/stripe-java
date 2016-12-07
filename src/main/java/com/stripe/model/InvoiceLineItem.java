package com.stripe.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter @EqualsAndHashCode(callSuper=false)
public class InvoiceLineItem extends StripeObject implements HasId {
	String id;
	Long amount;
	String currency;
	String description;
	Boolean discountable;
	Boolean livemode;
	Map<String, String> metadata;
	InvoiceLineItemPeriod period;
	Plan plan;
	Boolean proration;
	Integer quantity;
	String subscription;
	String type;
}
