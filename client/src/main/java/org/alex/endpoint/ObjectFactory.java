
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

    private final static QName _GeneralSecurityException_QNAME = new QName("http://endpoint.alex.org/", "GeneralSecurityException");
    private final static QName _UnsupportedEncodingException_QNAME = new QName("http://endpoint.alex.org/", "UnsupportedEncodingException");
    private final static QName _CreateToken_QNAME = new QName("http://endpoint.alex.org/", "createToken");
    private final static QName _CreateTokenResponse_QNAME = new QName("http://endpoint.alex.org/", "createTokenResponse");
    private final static QName _LoginCheck_QNAME = new QName("http://endpoint.alex.org/", "loginCheck");
    private final static QName _LoginCheckResponse_QNAME = new QName("http://endpoint.alex.org/", "loginCheckResponse");
    private final static QName _PasswordCheck_QNAME = new QName("http://endpoint.alex.org/", "passwordCheck");
    private final static QName _PasswordCheckResponse_QNAME = new QName("http://endpoint.alex.org/", "passwordCheckResponse");
    private final static QName _TokenCheck_QNAME = new QName("http://endpoint.alex.org/", "tokenCheck");
    private final static QName _TokenCheckResponse_QNAME = new QName("http://endpoint.alex.org/", "tokenCheckResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.alex.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GeneralSecurityException }
     * 
     */
    public GeneralSecurityException createGeneralSecurityException() {
        return new GeneralSecurityException();
    }

    /**
     * Create an instance of {@link UnsupportedEncodingException }
     * 
     */
    public UnsupportedEncodingException createUnsupportedEncodingException() {
        return new UnsupportedEncodingException();
    }

    /**
     * Create an instance of {@link CreateToken }
     * 
     */
    public CreateToken createCreateToken() {
        return new CreateToken();
    }

    /**
     * Create an instance of {@link CreateTokenResponse }
     * 
     */
    public CreateTokenResponse createCreateTokenResponse() {
        return new CreateTokenResponse();
    }

    /**
     * Create an instance of {@link LoginCheck }
     * 
     */
    public LoginCheck createLoginCheck() {
        return new LoginCheck();
    }

    /**
     * Create an instance of {@link LoginCheckResponse }
     * 
     */
    public LoginCheckResponse createLoginCheckResponse() {
        return new LoginCheckResponse();
    }

    /**
     * Create an instance of {@link PasswordCheck }
     * 
     */
    public PasswordCheck createPasswordCheck() {
        return new PasswordCheck();
    }

    /**
     * Create an instance of {@link PasswordCheckResponse }
     * 
     */
    public PasswordCheckResponse createPasswordCheckResponse() {
        return new PasswordCheckResponse();
    }

    /**
     * Create an instance of {@link TokenCheck }
     * 
     */
    public TokenCheck createTokenCheck() {
        return new TokenCheck();
    }

    /**
     * Create an instance of {@link TokenCheckResponse }
     * 
     */
    public TokenCheckResponse createTokenCheckResponse() {
        return new TokenCheckResponse();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneralSecurityException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "GeneralSecurityException")
    public JAXBElement<GeneralSecurityException> createGeneralSecurityException(GeneralSecurityException value) {
        return new JAXBElement<GeneralSecurityException>(_GeneralSecurityException_QNAME, GeneralSecurityException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnsupportedEncodingException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "UnsupportedEncodingException")
    public JAXBElement<UnsupportedEncodingException> createUnsupportedEncodingException(UnsupportedEncodingException value) {
        return new JAXBElement<UnsupportedEncodingException>(_UnsupportedEncodingException_QNAME, UnsupportedEncodingException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "createToken")
    public JAXBElement<CreateToken> createCreateToken(CreateToken value) {
        return new JAXBElement<CreateToken>(_CreateToken_QNAME, CreateToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateTokenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "createTokenResponse")
    public JAXBElement<CreateTokenResponse> createCreateTokenResponse(CreateTokenResponse value) {
        return new JAXBElement<CreateTokenResponse>(_CreateTokenResponse_QNAME, CreateTokenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginCheck }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "loginCheck")
    public JAXBElement<LoginCheck> createLoginCheck(LoginCheck value) {
        return new JAXBElement<LoginCheck>(_LoginCheck_QNAME, LoginCheck.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginCheckResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "loginCheckResponse")
    public JAXBElement<LoginCheckResponse> createLoginCheckResponse(LoginCheckResponse value) {
        return new JAXBElement<LoginCheckResponse>(_LoginCheckResponse_QNAME, LoginCheckResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PasswordCheck }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "passwordCheck")
    public JAXBElement<PasswordCheck> createPasswordCheck(PasswordCheck value) {
        return new JAXBElement<PasswordCheck>(_PasswordCheck_QNAME, PasswordCheck.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PasswordCheckResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "passwordCheckResponse")
    public JAXBElement<PasswordCheckResponse> createPasswordCheckResponse(PasswordCheckResponse value) {
        return new JAXBElement<PasswordCheckResponse>(_PasswordCheckResponse_QNAME, PasswordCheckResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TokenCheck }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "tokenCheck")
    public JAXBElement<TokenCheck> createTokenCheck(TokenCheck value) {
        return new JAXBElement<TokenCheck>(_TokenCheck_QNAME, TokenCheck.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TokenCheckResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.alex.org/", name = "tokenCheckResponse")
    public JAXBElement<TokenCheckResponse> createTokenCheckResponse(TokenCheckResponse value) {
        return new JAXBElement<TokenCheckResponse>(_TokenCheckResponse_QNAME, TokenCheckResponse.class, null, value);
    }

}
