package com.implementacao3.praticaintegradora3.service;

import com.implementacao3.praticaintegradora3.model.Actors;

public interface IActorService {

    Actors findByFirstName(String fistName);

    Actors findByLastName(String fistName);

    Actors findByFirstNameAndLastName (String firstName, String lastName);
}
