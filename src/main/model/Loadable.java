package model;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Loadable {
    Team load() throws IOException, ClassNotFoundException;
}
