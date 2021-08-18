package com.example.prviewer.model

data class PRModel (
                  val title : String? ,
                  val created_at : String? ,
                  val closed_at : String? ,
                  val state : String?,
                  val user : User?
                  );

data class User(
               val login : String? ,
               val avatar_url : String?
               );