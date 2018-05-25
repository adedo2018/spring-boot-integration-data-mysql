package com.example.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Book")
@Data
@NoArgsConstructor
public class Book implements Serializable {

  @Id
  @GeneratedValue
  @Column(name="BOOK_ID")
  private Long id;

  @Column(name="TITLE")
  private String title;

  @Column(name="TYPE")
  private String type;

  @Column(name="AUTHOR_FIRST_NAME")
  private String firstName;

  @Column(name="AUTHOR_LAST_NAME")
  private String lastName;

  @Column(name="GENRE")
  private String genre;

}