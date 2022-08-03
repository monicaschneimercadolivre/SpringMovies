package com.implementacao3.praticaintegradora3.service;

import com.implementacao3.praticaintegradora3.model.Actors;

public interface IActorService {

    Actors getById(long id) throws Exception;

    Actors findByFirstNameAndLastName (String firstName, String lastName);
}
