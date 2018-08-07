package com.blessedbin.frame.ucenter.modal;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Table(name = "oauth_client_details")
public class OauthClientDetails {

    /**
     * 主键,必须唯一,不能为空.
     * 用于唯一标识每一个客户端(client); 在注册时必须填写(也可由服务端自动生成).
     * 对于不同的grant_type,该字段都是必须的. 在实际应用中的另一个名称叫appKey,与client_id是同一个概念.
     */
    @Id
    @Column(name = "client_id")
    @NotBlank
    private String clientId;

    /**
     * 客户端所能访问的资源id集合,多个资源时用逗号(,)分隔,如: "unity-resource,mobile-resource".
     * 该字段的值必须来源于与security.xml中标签‹oauth2:resource-server的属性resource-id值一致. 在security.xml配置有几个‹oauth2:resource-server标签, 则该字段可以使用几个该值.
     * 在实际应用中, 我们一般将资源进行分类,并分别配置对应的‹oauth2:resource-server,如订单资源配置一个‹oauth2:resource-server, 用户资源又配置一个‹oauth2:resource-server.
     * 当注册客户端时,根据实际需要可选择资源id,也可根据不同的注册流程,赋予对应的资源id.
     */
    @Column(name = "resource_ids")
    private String resourceIds;

    /**
     * 用于指定客户端(client)的访问密匙; 在注册时必须填写(也可由服务端自动生成).
     * 对于不同的grant_type,该字段都是必须的. 在实际应用中的另一个名称叫appSecret,与client_secret是同一个概念.
     */
    @Column(name = "client_secret")
    @NotBlank
    private String clientSecret;

    /**
     * 指定客户端申请的权限范围,可选值包括read,write,trust;若有多个权限范围用逗号(,)分隔,如: "read,write".
     * scope的值与security.xml中配置的‹intercept-url的access属性有关系. 如‹intercept-url的配置为
     * ‹intercept-url pattern="/m/**" access="ROLE_MOBILE,SCOPE_READ"/>
     * 则说明访问该URL时的客户端必须有read权限范围. write的配置值为SCOPE_WRITE, trust的配置值为SCOPE_TRUST.
     * 在实际应该中, 该值一般由服务端指定, 常用的值为read,write.
     */
    @NotBlank
    private String scope;

    /**
     * 指定客户端支持的grant_type,可选值包括authorization_code,password,refresh_token,implicit,client_credentials, 若支持多个grant_type用逗号(,)分隔,如: "authorization_code,password".
     * 在实际应用中,当注册时,该字段是一般由服务器端指定的,而不是由申请者去选择的,
     * 最常用的grant_type组合有: "authorization_code,refresh_token"(针对通过浏览器访问的客户端);
     * "password,refresh_token"(针对移动设备的客户端).
     * implicit与client_credentials在实际中很少使用.
     */
    @Column(name = "authorized_grant_types")
    @NotBlank
    private String authorizedGrantTypes;

    /**
     * 客户端的重定向URI,可为空, 当grant_type为authorization_code或implicit时, 在Oauth的流程中会使用并检查与注册时填写的redirect_uri是否一致. 下面分别说明:
     * 当grant_type=authorization_code时, 第一步 从 spring-oauth-server获取 'code'时客户端发起请求时必须有redirect_uri参数, 该参数的值必须与 web_server_redirect_uri的值一致. 第二步 用 'code' 换取 'access_token' 时客户也必须传递相同的redirect_uri.
     * 在实际应用中, web_server_redirect_uri在注册时是必须填写的, 一般用来处理服务器返回的code, 验证state是否合法与通过code去换取access_token值.
     * 在spring-oauth-client项目中, 可具体参考AuthorizationCodeController.java中的authorizationCodeCallback方法.
     * 当grant_type=implicit时通过redirect_uri的hash值来传递access_token值.如:
     * http://localhost:7777/spring-oauth-client/implicit#access_token=dc891f4a-ac88-4ba6-8224-a2497e013865&token_type=bearer&expires_in=43199
     * 然后客户端通过JS等从hash值中取到access_token值.
     */
    @Column(name = "web_server_redirect_uri")
    private String webServerRedirectUri;

    /**
     * 指定客户端所拥有的Spring Security的权限值,可选, 若有多个权限值,用逗号(,)分隔, 如: "ROLE_UNITY,ROLE_USER".
     * 对于是否要设置该字段的值,要根据不同的grant_type来判断, 若客户端在Oauth流程中需要用户的用户名(username)与密码(password)的(authorization_code,password),
     * 则该字段可以不需要设置值,因为服务端将根据用户在服务端所拥有的权限来判断是否有权限访问对应的API.
     * 但如果客户端在Oauth流程中不需要用户信息的(implicit,client_credentials),
     * 则该字段必须要设置对应的权限值, 因为服务端将根据该字段值的权限来判断是否有权限访问对应的API.
     * (请在spring-oauth-client项目中来测试不同grant_type时authorities的变化)
     */
    private String authorities;

    /**
     * 设定客户端的access_token的有效时间值(单位:秒),可选, 若不设定值则使用默认的有效时间值(60 * 60 * 12, 12小时).
     * 在服务端获取的access_token JSON数据中的expires_in字段的值即为当前access_token的有效时间值.
     * 在项目中, 可具体参考DefaultTokenServices.java中属性accessTokenValiditySeconds.
     * 在实际应用中, 该值一般是由服务端处理的, 不需要客户端自定义.
     */
    @Column(name = "access_token_validity")
    private Integer accessTokenValidity;

    /**
     * 设定客户端的refresh_token的有效时间值(单位:秒),可选, 若不设定值则使用默认的有效时间值(60 * 60 * 24 * 30, 30天).
     * 若客户端的grant_type不包括refresh_token,则不用关心该字段 在项目中, 可具体参考DefaultTokenServices.java中属性refreshTokenValiditySeconds.
     *
     * 在实际应用中, 该值一般是由服务端处理的, 不需要客户端自定义.
     */
    @Column(name = "refresh_token_validity")
    private Integer refreshTokenValidity;

    /**
     * 这是一个预留的字段,在Oauth的流程中没有实际的使用,可选,但若设置值,必须是JSON格式的数据,如:
     * {"country":"CN","country_code":"086"}
     * 按照spring-security-oauth项目中对该字段的描述
     * Additional information for this client, not need by the vanilla OAuth protocol but might be useful, for example,for storing descriptive information.
     * (详见ClientDetails.java的getAdditionalInformation()方法的注释)
     * 在实际应用中, 可以用该字段来存储关于客户端的一些其他信息,如客户端的国家,地区,注册时的IP地址等等.
     */
    @Column(name = "additional_information")
    private String additionalInformation;

    /**
     * 设置用户是否自动Approval操作, 默认值为 'false', 可选值包括 'true','false', 'read','write'.
     * 该字段只适用于grant_type="authorization_code"的情况,当用户登录成功后,若该值为'true'或支持的scope值,则会跳过用户Approve的页面, 直接授权.
     * 该字段与 trusted 有类似的功能, 是 spring-security-oauth2 的 2.0 版本后添加的新属性.
     */
    private String autoapprove;

    /**
     * @return client_id
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * @param clientId
     */
    public void setClientId(String clientId) {
        this.clientId = clientId == null ? null : clientId.trim();
    }

    /**
     * @return resource_ids
     */
    public String getResourceIds() {
        return resourceIds;
    }

    /**
     * @param resourceIds
     */
    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds == null ? null : resourceIds.trim();
    }

    /**
     * @return client_secret
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * @param clientSecret
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret == null ? null : clientSecret.trim();
    }

    /**
     * @return scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * @param scope
     */
    public void setScope(String scope) {
        this.scope = scope == null ? null : scope.trim();
    }

    /**
     * @return authorized_grant_types
     */
    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    /**
     * @param authorizedGrantTypes
     */
    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes == null ? null : authorizedGrantTypes.trim();
    }

    /**
     * @return web_server_redirect_uri
     */
    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    /**
     * @param webServerRedirectUri
     */
    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri == null ? null : webServerRedirectUri.trim();
    }

    /**
     * @return authorities
     */
    public String getAuthorities() {
        return authorities;
    }

    /**
     * @param authorities
     */
    public void setAuthorities(String authorities) {
        this.authorities = authorities == null ? null : authorities.trim();
    }

    /**
     * @return access_token_validity
     */
    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    /**
     * @param accessTokenValidity
     */
    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    /**
     * @return refresh_token_validity
     */
    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    /**
     * @param refreshTokenValidity
     */
    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    /**
     * @return additional_information
     */
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * @param additionalInformation
     */
    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation == null ? null : additionalInformation.trim();
    }

    /**
     * @return autoapprove
     */
    public String getAutoapprove() {
        return autoapprove;
    }

    /**
     * @param autoapprove
     */
    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove == null ? null : autoapprove.trim();
    }
}