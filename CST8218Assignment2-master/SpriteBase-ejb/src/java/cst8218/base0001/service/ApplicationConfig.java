/* CST 8218-303 Assignment 2
 * Due: August 10th, 2021 
 * Group: 
 *  Phil Thesen     40797646
 *  Zach Dubuc      40725060
 *  Jonathan Wenek  40488779
 */
package cst8218.base0001.service;

import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;



@DatabaseIdentityStoreDefinition(
    dataSourceLookup = "${'java:comp/DefaultDataSource'}",
    callerQuery = "#{'select password from app.appuser where userid = ?'}",
    groupsQuery = "select groupname from app.appuser where userid = ?",
    hashAlgorithm = PasswordHash.class,
    priority = 10
) // support authentication from users within the appuser db-table
@BasicAuthenticationMechanismDefinition // defines a container authentication mechanism that implements the HTTP basic access auth protocol
@ApplicationScoped // this bean is scoped to the application
@Named 
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(cst8218.base0001.service.SpriteFacadeREST.class);
    }
    
}
