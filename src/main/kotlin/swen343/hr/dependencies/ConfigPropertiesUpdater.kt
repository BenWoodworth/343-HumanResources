package swen343.hr.dependencies

import swen343.hr.util.Updater

class ConfigPropertiesUpdater : Updater<ConfigProperties>({
    it.properties["port"] = "1234"
    it.properties["use-dummy-services"] = "true"
    it.properties["database.url"] = ""
    it.properties["database.user"] = ""
    it.properties["database.pass"] = ""
}, {
    if (it.properties["database-url"] == "") {
        it.properties["database-url"] = "jdbc:mysql://<address>:3306/<database>"
    }
}) {

    override fun initialize(updatable: ConfigProperties) {
        updatable.properties.clear()
    }

    override fun finalize(updatable: ConfigProperties) {
        updatable.save()
    }
}