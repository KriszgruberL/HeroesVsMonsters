package be.technifutur.utils;

import be.technifutur.models.entity.Entity;

public interface DieEventSubscriber {

    void execute(Entity e);
}
