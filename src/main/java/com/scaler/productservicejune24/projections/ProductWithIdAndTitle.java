package com.scaler.productservicejune24.projections;

//This package and interface is created to map the output of HQL query as we were not sure what to
//return if we have to fetch only some columns and not the whole Product object. So we'll give the name of
//this interface in the returntype of that HQL method
public interface ProductWithIdAndTitle {
    Long getId();
    String getTitle();
}