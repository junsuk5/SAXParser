package com.company.models;

public class Body {
 Items ItemsObject;
 private String numOfRows;
 private String pageNo;
 private String totalCount;


 // Getter Methods 

 public Items getItems() {
  return ItemsObject;
 }

 public String getNumOfRows() {
  return numOfRows;
 }

 public String getPageNo() {
  return pageNo;
 }

 public String getTotalCount() {
  return totalCount;
 }

 // Setter Methods 

 public void setItems(Items itemsObject) {
  this.ItemsObject = itemsObject;
 }

 public void setNumOfRows(String numOfRows) {
  this.numOfRows = numOfRows;
 }

 public void setPageNo(String pageNo) {
  this.pageNo = pageNo;
 }

 public void setTotalCount(String totalCount) {
  this.totalCount = totalCount;
 }
}