package persistence;

import org.json.JSONObject;

// referred to https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git for Writable
public interface Writable {
    JSONObject toJson();
}
