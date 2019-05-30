package com.company.models;

public class Response {
 Header HeaderObject;
 Body BodyObject;


 // Getter Methods 

 public Header getHeader() {
  return HeaderObject;
 }

 public Body getBody() {
  return BodyObject;
 }

 // Setter Methods 

 public void setHeader(Header headerObject) {
  this.HeaderObject = headerObject;
 }

 public void setBody(Body bodyObject) {
  this.BodyObject = bodyObject;
 }
}