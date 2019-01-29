
package org.alex.endpoint;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-01-22T14:39:45.623+03:00
 * Generated source version: 3.2.7
 */

@WebFault(name = "IllegalArgumentException", targetNamespace = "http://endpoint.alex.org/")
public class IllegalArgumentException_Exception extends Exception {

    private org.alex.endpoint.IllegalArgumentException illegalArgumentException;

    public IllegalArgumentException_Exception() {
        super();
    }

    public IllegalArgumentException_Exception(String message) {
        super(message);
    }

    public IllegalArgumentException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public IllegalArgumentException_Exception(String message, org.alex.endpoint.IllegalArgumentException illegalArgumentException) {
        super(message);
        this.illegalArgumentException = illegalArgumentException;
    }

    public IllegalArgumentException_Exception(String message, org.alex.endpoint.IllegalArgumentException illegalArgumentException, java.lang.Throwable cause) {
        super(message, cause);
        this.illegalArgumentException = illegalArgumentException;
    }

    public org.alex.endpoint.IllegalArgumentException getFaultInfo() {
        return this.illegalArgumentException;
    }
}
