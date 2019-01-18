
package org.alex.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.alex.endpoint package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _IllegalArgumentException_QNAME = new QName("http://endpoint.alex.org/", "IllegalArgumentException");
    private final static QName _Create_QNAME = new QName("http://endpoint.alex.org/", "create");
    private final static QName _CreateResponse_QNAME = new QName("http://endpoint.alex.org/", "createResponse");
    private final static QName _Delete_QNAME = new QName("http://endpoint.alex.org/", "delete");
    private final static QName _DeleteResponse_QNAME = new QName("http://endpoint.alex.org/", "deleteResponse");
    private final static QName _Get_QNAME = new QName("http://endpoint.alex.org/", "get");
    private final static QName _GetAll_QNAME = new QName("http://endpoint.alex.org/", "getAll");
    private final static QName _GetAllResponse_QNAME = new QName("http://endpoint.alex.org/", "getAllResponse");
    private final static QName _GetResponse_QNAME = new QName("http://endpoint.alex.org/", "getResponse");
    private final static QName _Merge_QNAME = new QName("http://endpoint.alex.org/", "merge");
    private final static QName _MergeResponse_QNAME = new QName("http://endpoint.alex.org/", "mergeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.alex.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IllegalArgumentException }
     * 
     */
    public IllegalArgumentException createIllegalArgumentException() {
        return new IllegalArgumentException();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link CreateResponse }
     * 
     */
    public CreateResponse createCreateResponse() {
        return new CreateResponse();
    }

    /**
     * Create an instance of {@link Delete }
     * 
     */
    public Delete createDelete() {
        return new Delete();
    }

    /**
     * Create an instance of {@link DeleteResponse }
     * 
     */
    public DeleteResponse createDeleteResponse() {
        return new DeleteResponse();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link GetAll }
     * 
     */
    public GetAll createGetAll() {
        return new GetAll();
    }

    /**
     * Create an instance of {@link GetAllResponse }
     * 
     */
    public GetAllResponse createGetAllResponse() {
        return new GetAllResponse();
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link Merge }
     * 
     */
    public Merge createMerge() {
        return new Merge();
    }

    /**
     * Create an instance of {@link MergeResponse }
     * 
     */
    public MergeResponse createMergeResponse() {
        return new MergeResponse();
    }

    /**
     * Create an instance of {@link Task }
     * 
     */
    public Task createTask() {
        return new Task();
    }

    /**
     * Create an instance of {@link AbstractEntity }
     * 
     */
    public AbstractEntity createAbstractEntity() {
        return new AbstractEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IllegalArgumentException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "IllegalArgumentException")
    public JAXBElement<IllegalArgumentException> createIllegalArgumentException(IllegalArgumentException value) {
        return new JAXBElement<IllegalArgumentException>(_IllegalArgumentException_QNAME, IllegalArgumentException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Create }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "create")
    public JAXBElement<Create> createCreate(Create value) {
        return new JAXBElement<Create>(_Create_QNAME, Create.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "createResponse")
    public JAXBElement<CreateResponse> createCreateResponse(CreateResponse value) {
        return new JAXBElement<CreateResponse>(_CreateResponse_QNAME, CreateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Delete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "delete")
    public JAXBElement<Delete> createDelete(Delete value) {
        return new JAXBElement<Delete>(_Delete_QNAME, Delete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "deleteResponse")
    public JAXBElement<DeleteResponse> createDeleteResponse(DeleteResponse value) {
        return new JAXBElement<DeleteResponse>(_DeleteResponse_QNAME, DeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Get }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "get")
    public JAXBElement<Get> createGet(Get value) {
        return new JAXBElement<Get>(_Get_QNAME, Get.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "getAll")
    public JAXBElement<GetAll> createGetAll(GetAll value) {
        return new JAXBElement<GetAll>(_GetAll_QNAME, GetAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "getAllResponse")
    public JAXBElement<GetAllResponse> createGetAllResponse(GetAllResponse value) {
        return new JAXBElement<GetAllResponse>(_GetAllResponse_QNAME, GetAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "getResponse")
    public JAXBElement<GetResponse> createGetResponse(GetResponse value) {
        return new JAXBElement<GetResponse>(_GetResponse_QNAME, GetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Merge }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "merge")
    public JAXBElement<Merge> createMerge(Merge value) {
        return new JAXBElement<Merge>(_Merge_QNAME, Merge.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MergeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "mergeResponse")
    public JAXBElement<MergeResponse> createMergeResponse(MergeResponse value) {
        return new JAXBElement<MergeResponse>(_MergeResponse_QNAME, MergeResponse.class, null, value);
    }

}
