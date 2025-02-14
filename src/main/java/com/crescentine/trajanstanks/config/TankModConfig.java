package com.crescentine.trajanstanks.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class TankModConfig {
    public static final ForgeConfigSpec.Builder BUILDER  = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> light_tank_health;
    public static final ForgeConfigSpec.ConfigValue<Integer> medium_tank_health;
    public static final ForgeConfigSpec.ConfigValue<Integer> heavy_tank_health;

    //panzer 2
    public static final ForgeConfigSpec.ConfigValue<Double> panzer2_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> panzer2_shot_cooldown;
    public static final ForgeConfigSpec.ConfigValue<Double> panzer2_heal_amount;
    public static final ForgeConfigSpec.ConfigValue<Double> panzer_2_maxfuel;


    //luchs
    public static final ForgeConfigSpec.ConfigValue<Double> luchs_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> luchs_shot_cooldown;
    public static final ForgeConfigSpec.ConfigValue<Double> luchs_heal_amount;
    public static final ForgeConfigSpec.ConfigValue<Double> luchs_maxfuel;


    //somua
    public static final ForgeConfigSpec.ConfigValue<Double> somua_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> somua_shot_cooldown;
    public static final ForgeConfigSpec.ConfigValue<Double> somua_heal_amount;
    public static final ForgeConfigSpec.ConfigValue<Double> somua_maxfuel;

    public static final ForgeConfigSpec.ConfigValue<Double> t34_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> t34_shot_cooldown;
    public static final ForgeConfigSpec.ConfigValue<Double> t34_heal_amount;
    public static final ForgeConfigSpec.ConfigValue<Double> t34_maxfuel;

    public static final ForgeConfigSpec.ConfigValue<Double> tiger_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> tiger_shot_cooldown;
    public static final ForgeConfigSpec.ConfigValue<Double> tiger_heal_amount;
    public static final ForgeConfigSpec.ConfigValue<Double> tiger_maxfuel;

    public static final ForgeConfigSpec.ConfigValue<Double> cruisermk1_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> cruisermk1_shot_cooldown;
    public static final ForgeConfigSpec.ConfigValue<Double> cruisermk1_heal_amount;
    public static final ForgeConfigSpec.ConfigValue<Double> cruisermk1_maxfuel;

    public static final ForgeConfigSpec.ConfigValue<Double> m4sherman_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> m4sherman_shot_cooldown;
    public static final ForgeConfigSpec.ConfigValue<Double> m4sherman_heal_amount;
    public static final ForgeConfigSpec.ConfigValue<Double> m4sherman_maxfuel;

    public static final ForgeConfigSpec.ConfigValue<Double> archer_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> archer_shot_cooldown;
    public static final ForgeConfigSpec.ConfigValue<Double> archer_heal_amount;
    public static final ForgeConfigSpec.ConfigValue<Double> archer_maxfuel;

    public static final ForgeConfigSpec.ConfigValue<Double> kv2_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> kv2_shot_cooldown;
    public static final ForgeConfigSpec.ConfigValue<Double> kv2_heal_amount;
    public static final ForgeConfigSpec.ConfigValue<Double> kv2_maxfuel;

    public static final ForgeConfigSpec.ConfigValue<Double> jagdpanther_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> jagdpanther_shot_cooldown;
    public static final ForgeConfigSpec.ConfigValue<Double> jagdpanther_heal_amount;
    public static final ForgeConfigSpec.ConfigValue<Double> jagdpanther_maxfuel;

    public static final ForgeConfigSpec.ConfigValue<Integer> pak40_health;
    public static final ForgeConfigSpec.ConfigValue<Integer> pak40_cooldown;

    public static final ForgeConfigSpec.ConfigValue<Integer> qf6_health;
    public static final ForgeConfigSpec.ConfigValue<Integer> qf6_cooldown;

    static {
        BUILDER.push("Trajan's Tanks Config");
        BUILDER.comment("Config File for Trajan's Tank Mod");
        BUILDER.pop();

        BUILDER.push("Tank Health");
        light_tank_health = BUILDER.define("Light Tank Health", 100);
        medium_tank_health = BUILDER.define("Medium Tank Health", 135);
        heavy_tank_health = BUILDER.define("Heavy Tank Health", 170);

        BUILDER.push("Panzer 2 Stats (Light Tank)");
        panzer2_speed = BUILDER.define("Panzer 2 Speed" , 0.17);
        panzer2_shot_cooldown = BUILDER.define("Panzer 2 Shot Cooldown (1 = 1/20 second)", 60);
        panzer2_heal_amount = BUILDER.define("Panzer 2 Healing Amount (on right click)", 10.0);
        panzer_2_maxfuel = BUILDER.define("Panzer 2 Max Fuel (seconds)", 600.0);
        BUILDER.pop();

        BUILDER.push("Luchs Stats (Light Tank)");
        luchs_speed = BUILDER.define("Luchs Speed" , 0.17);
        luchs_shot_cooldown = BUILDER.define("Luchs Shoot Cooldown (1 = 1/20 second)", 60);
        luchs_heal_amount = BUILDER.define("Luchs Healing Amount (on right click)", 10.0);
        luchs_maxfuel = BUILDER.define("Luchs Max Fuel (seconds)", 600.0);
        BUILDER.pop();

        BUILDER.push("Somua Stats (Light Tank)");
        somua_speed = BUILDER.define("Somua Speed" , 0.17);
        somua_shot_cooldown = BUILDER.define("Somua Shoot Cooldown (1 = 1/20 second)", 60);
        somua_heal_amount = BUILDER.define("Somua Healing Amount (on right click)", 10.0);
        somua_maxfuel = BUILDER.define("Somua Max Fuel (seconds)", 600.0);
        BUILDER.pop();

        BUILDER.push("Tiger Stats (Heavy Tank)");
        tiger_speed = BUILDER.define("Tiger Speed" , 0.15);
        tiger_shot_cooldown = BUILDER.define("Tiger Shoot Cooldown (1 = 1/20 second", 80);
        tiger_heal_amount = BUILDER.define("Tiger Healing Amount (on right click)", 10.0);
        tiger_maxfuel = BUILDER.define("Tiger Max Fuel (seconds)", 600.0);
        BUILDER.pop();

        BUILDER.push("T-34 Stats (Medium Tank)");
        t34_speed = BUILDER.define("T-34 Speed" , 0.16);
        t34_shot_cooldown = BUILDER.define("T-34 Shoot Cooldown (1 = 1/20 second", 70);
        t34_heal_amount = BUILDER.define("T-34 Healing Amount (on right click)", 10.0);
        t34_maxfuel = BUILDER.define("T-34 Max Fuel (seconds)", 600.0);
        BUILDER.pop();

        BUILDER.push("Cruiser MK1 Stats (Light Tank)");
        cruisermk1_speed = BUILDER.define("Cruiser MK1 Speed" , 0.17);
        cruisermk1_shot_cooldown = BUILDER.define("Cruiser MK1 Shoot Cooldown (1 = 1/20 second", 60);
        cruisermk1_heal_amount = BUILDER.define("Cruiser MK1 Healing Amount (on right click)", 10.0);
        cruisermk1_maxfuel = BUILDER.define("Cruiser MK1 Max Fuel (seconds)", 600.0);
        BUILDER.pop();

        BUILDER.push("M4 Sherman Stats (Medium Tank)");
        m4sherman_speed = BUILDER.define("M4 Sherman Speed" , 0.14);
        m4sherman_shot_cooldown = BUILDER.define("M4 Sherman Shoot Cooldown (1 = 1/20 second", 70);
        m4sherman_heal_amount = BUILDER.define("M4 Sherman Healing Amount (on right click)", 10.0);
        m4sherman_maxfuel = BUILDER.define("M4 Sherman Max Fuel (seconds)", 600.0);
        BUILDER.pop();

        BUILDER.push("Archer Stats (Medium Tank)");
        archer_speed = BUILDER.define("Archer Speed" , 0.16);
        archer_shot_cooldown = BUILDER.define("Archer Shoot Cooldown (1 = 1/20 second", 70);
        archer_heal_amount = BUILDER.define("Archer Healing Amount (on right click)", 10.0);
        archer_maxfuel = BUILDER.define("Archer Max Fuel (seconds)", 600.0);
        BUILDER.pop();

        BUILDER.push("KV-2 Stats (Heavy Tank)");
        kv2_speed = BUILDER.define("KV-2 Speed" , 0.15);
        kv2_shot_cooldown = BUILDER.define("KV-2 Shoot Cooldown (1 = 1/20 second", 80);
        kv2_heal_amount = BUILDER.define("KV-2 Healing Amount (on right click)", 10.0);
        kv2_maxfuel = BUILDER.define("KV-2 Max Fuel (seconds)", 600.0);
        BUILDER.pop();

        BUILDER.push("Jagdpanther Stats (Heavy Tank)");
        jagdpanther_speed = BUILDER.define("Jagdpanther Speed" , 0.14);
        jagdpanther_shot_cooldown = BUILDER.define("Jagdpanther Shoot Cooldown (1 = 1/20 second", 80);
        jagdpanther_heal_amount = BUILDER.define("Jagdpanther Healing Amount (on right click)", 10.0);
        jagdpanther_maxfuel = BUILDER.define("Jagdpanther Max Fuel (seconds)", 600.0);
        BUILDER.pop();

        BUILDER.push("Pak-40 Stats");
        pak40_health = BUILDER.define("Pak-40 Health", 15);
        pak40_cooldown = BUILDER.define("Pak-40 Shot Cooldown (1 = 1/20 second)", 75);
        BUILDER.pop();

        BUILDER.push("Qf-6 Stats");
        qf6_health = BUILDER.define("QF-6 Health", 15);
        qf6_cooldown = BUILDER.define("QF-6 Shot Cooldown (1 = 1/20 second)", 75);
        BUILDER.pop();

       SPEC = BUILDER.build();
    }
}
