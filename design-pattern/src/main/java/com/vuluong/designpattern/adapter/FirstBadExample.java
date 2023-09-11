package com.vuluong.designpattern.adapter;

/**
 * Create a new client method that accepts 3rd-party interface
 * --> duplicate business code
 */
public class FirstBadExample {

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

    public static class ThirdPartyClass implements ThirdPartyInterface {

        public void doSpecificAction(JSON json) {
            System.out.println("do specific action with: " + json.getJsonContent());
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

        /**
         * BAD!: duplicate business logic here
         * Also, our client class is supposed to only deal with xml-related stuffs
         */
        public void doBusinessLogicWithThirdParty(ThirdPartyInterface thirdParty) {
            XML xml = new XML("this is xml data");
            String jsonString = xml.getXmlContent().replace("xml", "json");
            JSON json = new JSON(jsonString);
            thirdParty.doSpecificAction(json);
        }
    }

    public static void main(String[] args) {
        // can't reuse BusinessClass.doBusinessLogic(XMLConsumer)
        // since our ThirdPartyClass isn't implementing XMLConsumer
        new BusinessClass().doBusinessLogicWithThirdParty(new ThirdPartyClass());
    }
}
