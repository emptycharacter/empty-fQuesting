rootProject.name = "empty-fQuesting"

//include("e-PluginUtils")
include("empty-TutorialIsland")
include("empty-CooksAssistant")
include("empty-SheepShearer")
include("empty-XMarksTheSpot")
include("empty-PiratesTreasure")
include("empty-RuneMysteries")
include("empty-RomeoAndJuliet")
include("empty-TheRestlessGhost")
include("empty-PrinceAliRescue")
include("empty-MisthalinMystery")
include("empty-ImpCatcher")
include("empty-ErnestTheChicken")
include("empty-VampyreSlayer")
include("empty-DoricsQuest")
include("empty-BlackKnightsFortress")
include("empty-ShieldOfArrav")
include("empty-DemonSlayer")
include("empty-BelowIceMountain")
include("empty-TheKnightsSword")
include("empty-WitchsPotion")
include("empty-TheCorsairCurse")
include("empty-GoblinDiplomacy")
include("empty-DragonSlayerOne")



for (project in rootProject.children) {
    project.apply {
        projectDir = file(name)
        buildFileName = "$name.gradle.kts"

        require(projectDir.isDirectory) { "Project '${project.path} must have a $projectDir directory" }
        require(buildFile.isFile) { "Project '${project.path} must have a $buildFile build script" }
    }
}