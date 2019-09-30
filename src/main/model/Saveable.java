package model;

import java.io.IOException;

public interface Saveable {
    void save(Team team) throws IOException;
}
