package swen343.hr.dependencies

import swen343.hr.util.Updater

class ConfigPropertiesUpdater : Updater<ConfigProperties>({
    properties["port"] = "1234"
    properties["use-dummy-services"] = "true"
    properties["database.url"] = ""
    properties["database.user"] = ""
    properties["database.pass"] = ""
}, {
    if (properties["database-url"] == "") {
        properties["database-url"] = "jdbc:mysql://<address>:3306/<database>"
    }
}, {
    properties["session-duration.seconds"] = "604800"
}) {

    override fun initialize(updatable: ConfigProperties) {
        updatable.properties.clear()
    }

    override fun finalize(updatable: ConfigProperties) {
        updatable.save()
    }
}