package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class Merge_element implements com.sforce.ws.bind.XMLizable , IMerge_element{

    /**
     * Constructor
     */
    public Merge_element() {}

    /**
     * element : request of type {urn:partner.soap.sforce.com}MergeRequest
     * java type: com.sforce.soap.partner.MergeRequest[]
     */
    private static final com.sforce.ws.bind.TypeInfo request__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","request","urn:partner.soap.sforce.com","MergeRequest",0,-1,true);

    private boolean request__is_set = false;

    private com.sforce.soap.partner.MergeRequest[] request = new com.sforce.soap.partner.MergeRequest[0];

    @Override
    public com.sforce.soap.partner.MergeRequest[] getRequest() {
      return request;
    }

    @Override
    public void setRequest(com.sforce.soap.partner.IMergeRequest[] request) {
      this.request = castArray(com.sforce.soap.partner.MergeRequest.class, request);
      request__is_set = true;
    }

    protected void setRequest(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.isElement(__in, request__typeInfo)) {
        setRequest((com.sforce.soap.partner.MergeRequest[])__typeMapper.readObject(__in, request__typeInfo, com.sforce.soap.partner.MergeRequest[].class));
      }
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       __typeMapper.writeObject(__out, request__typeInfo, request, request__is_set);
    }

    @Override
    public void load(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __typeMapper.consumeStartTag(__in);
      loadFields(__in, __typeMapper);
      __typeMapper.consumeEndTag(__in);
    }

    protected void loadFields(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
        setRequest(__in, __typeMapper);
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[Merge_element ");
      sb.append(" request='").append(com.sforce.ws.util.Verbose.toString(request)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private <T,U> T[] castArray(Class<T> clazz, U[] array) {
        if (array == null) {
            return null;
        }
        T[] retVal = (T[]) java.lang.reflect.Array.newInstance(clazz, array.length);
        for (int i=0; i < array.length; i++) {
            retVal[i] = (T)array[i];
        }

        return retVal;
	}
}