package com.example.jokeprovider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeProvider {

    Random mRandom = new Random();

    List<String> jokes = new ArrayList<>();


    public String getJoke() {
        jokes.add("Why are cats so good at video games? \n Because they have nine lives!");
        jokes.add("What do you get when you cross Sonic The Hedgehog and Curious George? \n " +
                "2 Fast 2 Curious.");
        jokes.add("What does Sonic use to knock on a door? \n Knuckles.");
        jokes.add("How do you get a Bulbasaur on a bus? \n You poke 'em on!");
        jokes.add("What did Princess Zelda eat for breakfast? \n A sausage Link.");
        jokes.add("Why shouldn't you ask Yoda for money? \n Because he's always a little short.");
        jokes.add("Why is a Jedi knight never lonely? \n Because the force is always with him.");
        jokes.add("How do you cure Hunger in Minecraft? \n Three Square Meals.");
        jokes.add("How does Steve stay in shape? \n He runs around the BLOCK.");

        return jokes.get(mRandom.nextInt(jokes.size()));
    }

}