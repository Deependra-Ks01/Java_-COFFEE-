import java.util.HashMap;
import java.util.Map;

public class InstrumentSpec {
    private Map<String, Object> properties;

    public InstrumentSpec(Map<String, Object> properties) {
        if (properties == null) {
            this.properties = new HashMap<>();
        } else {
            this.properties = new HashMap<>(properties);
        }
    }

    public Map<String, Object> getProperties() {
        return new HashMap<>(properties);
    }

    public Object getProperty(String propertyName) {
        if (propertyName == null) {
            return null;
        }
        return properties.get(propertyName.toLowerCase());
    }

    public void setProperty(String propertyName, Object value) {
        if (propertyName == null) {
            return;
        }
        if (value == null) {
            properties.remove(propertyName.toLowerCase());
        } else {
            properties.put(propertyName.toLowerCase(), value);
        }
    }

    public boolean matches(InstrumentSpec otherSpec) {
        if (otherSpec == null) {
            return true;
        }

        for (Map.Entry<String, Object> entry : otherSpec.properties.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            Object thisValue = properties.get(key);
            if (value == null) {
                continue;
            }
            if (thisValue == null) {
                return false;
            }
            if (thisValue instanceof String && value instanceof String) {
                String s1 = ((String) thisValue).trim();
                String s2 = ((String) value).trim();
                if (!s1.equalsIgnoreCase(s2)) {
                    return false;
                }
            } else {
                if (!thisValue.equals(value)) {
                    return false;
                }
            }
        }
        return true;
    }
}
