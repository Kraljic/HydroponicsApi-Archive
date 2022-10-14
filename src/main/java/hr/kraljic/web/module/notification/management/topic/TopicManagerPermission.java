package hr.kraljic.web.module.notification.management.topic;

import hr.kraljic.web.module.core.permission.AbstractPermission;
import hr.kraljic.web.module.core.permission.PermissionInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Configuration
public class TopicManagerPermission extends AbstractPermission {
    public static final String PREFIX = "TOPICMANAGER_";

    public static final String ACCESS = PREFIX + "ACCESS";
    public static final String READ = PREFIX + "READ";
    public static final String WRITE = PREFIX + "WRITE";

    public TopicManagerPermission(PermissionInitializer permissionInitializer) {
        super(permissionInitializer);
    }

    @Override
    public String[] registerPermissions() {
        return new String[]{
                ACCESS,
                READ,
                WRITE,
        };
    }

    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @PreAuthorize("hasAuthority('" + ACCESS + "')")
    public @interface Access {
    }

    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @PreAuthorize("hasAuthority('" + READ + "')")
    public @interface Read {
    }

    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @PreAuthorize("hasAuthority('" + WRITE + "')")
    public @interface Write {
    }

}
