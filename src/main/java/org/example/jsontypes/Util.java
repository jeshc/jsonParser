package org.example.jsontypes;

public class Util {
    //public static String REGEX_JSON_PAIRS = "(?:\\\"|\\')(?<key>[@#\\w\\d\\s]+)(?:\\\"|\\')\\s*:(.*)";
    public static String REGEX_JSON_PAIRS = "(?:\\\"|\\')(?<key>[@#\\w\\d\\s]+)(?:\\\"|\\')\\s*:(.*)";

    public static final String TEST1 = "{\n" +
            "    \"transaction\": {\n" +
            "        \"id\": \"6753322\",\n" +
            "        \"number\": {\n" +
            "            \"@region\": \"Russia\",\n" +
            "            \"#number\": \"8-900-000-000\"\n" +
            "        },\n" +
            "        \"empty1\": null,\n" +
            "        \"empty2\": { },\n" +
            "        \"empty3\": \"\",\n" +
            "        \"inner1\": {\n" +
            "            \"inner2\": {\n" +
            "                \"inner3\": {\n" +
            "                    \"key1\": \"value1\",\n" +
            "                    \"key2\": \"value2\"\n" +
            "                }\n" +
            "            }\n" +
            "        },\n" +
            "        \"inner4\": {\n" +
            "            \"@\": 123,\n" +
            "            \"#inner4\": \"value3\"\n" +
            "        },\n" +
            "        \"inner4.2\": {\n" +
            "            \"\": 123,\n" +
            "            \"#inner4.2\": \"value3\"\n" +
            "        },\n" +
            "        \"inner5\": {\n" +
            "            \"@attr1\": 123.456,\n" +
            "            \"#inner4\": \"value4\"\n" +
            "        },\n" +
            "        \"inner6\": {\n" +
            "            \"@attr2\": 789.321,\n" +
            "            \"#inner6\": \"value5\"\n" +
            "        },\n" +
            "        \"inner7\": {\n" +
            "            \"#inner7\": \"value6\"\n" +
            "        },\n" +
            "        \"inner8\": {\n" +
            "            \"@attr3\": \"value7\"\n" +
            "        },\n" +
            "        \"inner9\": {\n" +
            "            \"@attr4\": \"value8\",\n" +
            "            \"#inner9\": \"value9\",\n" +
            "            \"something\": \"value10\"\n" +
            "        },\n" +
            "        \"inner10\": {\n" +
            "            \"@attr5\": null,\n" +
            "            \"#inner10\": null\n" +
            "        },\n" +
            "        \"inner11\": {\n" +
            "            \"@\": null,\n" +
            "            \"#\": null\n" +
            "        },\n" +
            "        \"inner12\": {\n" +
            "            \"@somekey\": \"attrvalue\",\n" +
            "            \"#inner12\": null,\n" +
            "            \"somekey\": \"keyvalue\",\n" +
            "            \"inner12\": \"notnull\"\n" +
            "        },\n" +
            "        \"inner13\": {\n" +
            "            \"@invalid_attr\": {\n" +
            "                \"some_key\": \"some value\"\n" +
            "            },\n" +
            "            \"#inner13\": {\n" +
            "                \"key\": \"value\"\n" +
            "            }\n" +
            "        },\n" +
            "        \"\": {\n" +
            "            \"#\": null,\n" +
            "            \"secret\": \"this won't be converted\"\n" +
            "        }\n" +
            "    },\n" +
            "    \"meta\": {\n" +
            "        \"version\": 0.01\n" +
            "    },\n\"extra\" : 888 \n" +
            "}";
    public static final String TEST2 ="{\n" +
            "    \"key\": {\n" +
            "        \"child_key1\": \"child_key_value\",\n" +
            "        \"child_key2\": \"child_key_value\",\n" +
            "        \"child_key3\": {\n" +
            "            \"child_child_key\": \"value\"\n" +
            "        },\n" +
            "        \"child_key4\": {\n" +
            "            \"child_child_key1\": \"value1\",\n" +
            "            \"child_child_key2\": \"value2\"\n" +
            "        }\n" +
            "    }\n" +
            "}";

    public static final String TEST3 = "{\n" +
            "    \"elem1\": {\n" +
            "        \"@attr1\": \"val1\",\n" +
            "        \"@attr2\": \"val2\",\n" +
            "        \"#elem1\": {\n" +
            "            \"elem2\": {\n" +
            "                \"@attr3\": \"val3\",\n" +
            "                \"@attr4\": \"val4\",\n" +
            "                \"#elem2\": \"Value1\"\n" +
            "            },\n" +
            "            \"elem3\": {\n" +
            "                \"@attr5\": \"val5\",\n" +
            "                \"@attr6\": \"val6\",\n" +
            "                \"#elem3\": \"Value2\"\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "}";

    public static final String TEST4 ="{\n" +
            "    \"@version\": 1.0,\n" +
            "    \"@attx\": \"valuex\",\n" +
            "    \"transaction\": {\n" +
            "        \"id\": \"6753322\",\n" +
            "        \"number\": {\n" +
            "            \"@region\": \"Russia\",\n" +
            "            \"#number\": \"8-900-000-000\"\n" +
            "        },\n" +
            "        \"empty1\": null,\n" +
            "        \"empty2\": { },\n" +
            "        \"empty3\": \"\",\n" +
            "        \"inner1\": {\n" +
            "            \"inner2\": {\n" +
            "                \"inner3\": {\n" +
            "                    \"key1\": \"value1\",\n" +
            "                    \"key2\": \"value2\"\n" +
            "                }\n" +
            "            }\n" +
            "        },\n" +
            "        \"inner4\": {\n" +
            "            \"@\": 123,\n" +
            "            \"#inner4\": \"value3\"\n" +
            "        },\n" +
            "        \"inner4.2\": {\n" +
            "            \"\": 123,\n" +
            "            \"#inner4.2\": \"value3\"\n" +
            "        },\n" +
            "        \"inner5\": {\n" +
            "            \"@attr1\": 123.456,\n" +
            "            \"#inner4\": \"value4\"\n" +
            "        },\n" +
            "        \"inner6\": {\n" +
            "            \"@attr2\": 789.321,\n" +
            "            \"#inner6\": \"value5\"\n" +
            "        },\n" +
            "        \"inner7\": {\n" +
            "            \"#inner7\": \"value6\"\n" +
            "        },\n" +
            "        \"inner8\": {\n" +
            "            \"@attr3\": \"value7\"\n" +
            "        },\n" +
            "        \"inner9\": {\n" +
            "            \"@attr4\": \"value8\",\n" +
            "            \"#inner9\": \"value9\",\n" +
            "            \"something\": \"value10\"\n" +
            "        },\n" +
            "        \"inner10\": {\n" +
            "            \"@attr5\": null,\n" +
            "            \"#inner10\": null\n" +
            "        },\n" +
            "        \"inner11\": {\n" +
            "            \"@\": null,\n" +
            "            \"#\": null\n" +
            "        },\n" +
            "        \"inner12\": {\n" +
            "            \"@somekey\": \"attrvalue\",\n" +
            "            \"#inner12\": null,\n" +
            "            \"somekey\": \"keyvalue\",\n" +
            "            \"inner12\": \"notnull\"\n" +
            "        },\n" +
            "        \"inner13\": {\n" +
            "            \"@invalid_attr\": {\n" +
            "                \"some_key\": \"some value\"\n" +
            "            },\n" +
            "            \"#inner13\": {\n" +
            "                \"key\": \"value\"\n" +
            "            }\n" +
            "        },\n" +
            "        \"\": {\n" +
            "            \"#\": null,\n" +
            "            \"secret\": \"this won't be converted\"\n" +
            "        }\n" +
            "    },\n" +
            "    \"meta\": {\n" +
            "        \"version\": 0.01\n" +
            "    },\n" +
            "\"extra\" : 888 \n" +
            "}";

    public static final String TEST5 = "{\n" +
            "    \"root1\": {\n" +
            "        \"@attr1\": \"val1\",\n" +
            "        \"@attr2\": \"val2\",\n" +
            "        \"#root1\": {\n" +
            "            \"elem1\": {\n" +
            "                \"@attr3\": \"val3\",\n" +
            "                \"@attr4\": \"val4\",\n" +
            "                \"#elem1\": \"Value1\"\n" +
            "            },\n" +
            "            \"elem2\": {\n" +
            "                \"@attr5\": \"val5\",\n" +
            "                \"@attr6\": \"val6\",\n" +
            "                \"#elem2\": \"Value2\"\n" +
            "            }\n" +
            "        }\n" +
            "    },\n" +
            "    \"root2\": {\n" +
            "        \"@attr1\": null,\n" +
            "        \"@attr2\": \"\",\n" +
            "        \"#root2\": null\n" +
            "    },\n" +
            "    \"root3\": {\n" +
            "        \"@attr1\": \"val2\",\n" +
            "        \"@attr2\": \"val1\",\n" +
            "        \"#root3\": \"\"\n" +
            "    },\n" +
            "    \"root4\": \"Value4\"\n" +
            "}";
}
