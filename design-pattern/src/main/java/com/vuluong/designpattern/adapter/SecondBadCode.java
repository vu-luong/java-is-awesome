package com.vuluong.designpattern.adapter;

/**
 * Needs to modify 3rd-party code, which is not always a possible approach
 */
public class SecondBadCode {

    public static class JSON {
        private final String content;

        public JSON(String content) {
            this.content = content;
        }
        
        public String getJsonContent() {
            return content;
        }
    }
    
    /**
     * The 3rd-party library only handles JSON data format
     */
    public interface ThirdPartyInterface {
        void doSpecificAction(JSON json);
    }

    public static class ThirdPartyClass implements ThirdPartyInterface, XMLConsumer {

        @Override
        public void doSpecificAction(JSON json) {
            System.out.println("do specific action with: " + json.getJsonContent());
        }

        /**
         * BAD!: this is inside 3rd-party class, which is not always modifiable
         */
        @Override
        public void doAction(XML xml) {
            String jsonString = xml.getXmlContent().replace("xml", "json");
            JSON json = new JSON(jsonString);
            doSpecificAction(json);
        }
    }
    
    public static class XML {
        private final String content;

        public XML(String content) {
            this.content = content;
        }
        
        public String getXmlContent() {
            return content;
        }
    }
    
    public interface XMLConsumer {
        void doAction(XML xml);
    }

    /**
     * Our client code only deals with XMLConsumer
     */
    public static class BusinessClass {

        public void doBusinessLogic(XMLConsumer client) {
            XML xml = new XML("this is xml data");
            client.doAction(xml);
        }
    }

    public static void main(String[] args) {
        new BusinessClass().doBusinessLogic(new ThirdPartyClass());
    }
}
