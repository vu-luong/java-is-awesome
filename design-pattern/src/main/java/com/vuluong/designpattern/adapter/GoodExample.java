package com.vuluong.designpattern.adapter;

/**
 * 1. Why is adapter better than static converter method?
 * -> Adapter needs to handle both type conversion and adaptee's specific operation
 * 2. The implementation `Adapter implements ClientInterface` is optional
 */
public class GoodExample {

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

        @Override
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

    public static class ThirdPartyXmlAdapter implements XMLConsumer {

        private final ThirdPartyInterface thirdParty = new ThirdPartyClass();

        @Override
        public void doAction(XML xml) {
            thirdParty.doSpecificAction(convertXml2Json(xml));
        }

        private JSON convertXml2Json(XML xml) {
            String jsonContent = xml.getXmlContent()
                .replace("xml", "json");
            return new JSON(jsonContent);
        }
    }

    /**
     * Our client code only deals with XMLConsumer
     */
    public static class OurBusiness {

        public void doBusinessLogic(XMLConsumer client) {
            XML xml = new XML("this is xml data");
            client.doAction(xml);
        }
    }

    public static void main(String[] args) {
        ThirdPartyXmlAdapter adapter = new ThirdPartyXmlAdapter();
        new OurBusiness().doBusinessLogic(adapter);
    }
}
