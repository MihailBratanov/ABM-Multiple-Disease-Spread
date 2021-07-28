package abm_multiple_disease_spread;

import static abm_multiple_disease_spread.SocialActivity.*;
import static com.xj.anylogic.engine.HyperArray.*;
import static com.xj.anylogic.engine.UtilitiesArray.*;
import static com.xj.anylogic.engine.presentation.UtilitiesColor.*;
import static com.xj.anylogic.engine.presentation.UtilitiesDrawing.*;
import static java.lang.Math.*;

import com.xj.anylogic.engine.*;
import com.xj.anylogic.engine.Position;
import com.xj.anylogic.engine.analysis.*;
import com.xj.anylogic.engine.connectivity.*;
import com.xj.anylogic.engine.connectivity.ResultSet;
import com.xj.anylogic.engine.connectivity.Statement;
import com.xj.anylogic.engine.markup.*;
import com.xj.anylogic.engine.markup.DensityMap;
import com.xj.anylogic.engine.markup.Network;
import com.xj.anylogic.engine.markup.PedFlowStatistics;
import com.xj.anylogic.engine.presentation.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.io.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.Timer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import org.w3c.dom.css.Counter;

public class Main extends Agent {

  /**
   * pauseSimulation Dynamic Event Class
   */
  public static class pauseSimulation extends DynamicEvent {

    /**
     * Constructor<br>
     * Use <code>create_pauseSimulation</code> method
     */
    public pauseSimulation(Main _ao_xjal, double _dt_xjal) {
      super(_ao_xjal, _dt_xjal);
    }

    @AnyLogicInternalCodegenAPI
    public void execute() {
      super.execute(); // must be called!
      ((Main) getAgent()).on_pauseSimulation_xjal();
    }

    /**
     * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
     */
    @AnyLogicInternalCodegenAPI
    private static final long serialVersionUID = 2497856770940248751L;
  }

  /**
   * startSimulation Dynamic Event Class
   */
  public static class startSimulation extends DynamicEvent {

    /**
     * Constructor<br>
     * Use <code>create_startSimulation</code> method
     */
    public startSimulation(Main _ao_xjal, double _dt_xjal) {
      super(_ao_xjal, _dt_xjal);
    }

    @AnyLogicInternalCodegenAPI
    public void execute() {
      super.execute(); // must be called!
      ((Main) getAgent()).on_startSimulation_xjal();
    }

    /**
     * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
     */
    @AnyLogicInternalCodegenAPI
    private static final long serialVersionUID = 2497856770939204586L;
  }

  /**
   * infectEvent Dynamic Event Class
   */
  public static class infectEvent extends DynamicEvent {

    /**
     * Constructor<br>
     * Use <code>create_infectEvent</code> method
     */
    public infectEvent(Main _ao_xjal, double _dt_xjal) {
      super(_ao_xjal, _dt_xjal);
    }

    @AnyLogicInternalCodegenAPI
    public void execute() {
      super.execute(); // must be called!
      ((Main) getAgent()).on_infectEvent_xjal();
    }

    /**
     * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
     */
    @AnyLogicInternalCodegenAPI
    private static final long serialVersionUID = 2497856772014011135L;
  }

  // Excel Files
  public ExcelFile resultsFile = new ExcelFile("results.xlsx", false);

  // Parameters

  public int numHospitals;

  /**
   * Returns default value for parameter <code>numHospitals</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _numHospitals_DefaultValue_xjal() {
    final Main self = this;
    return 0;
  }

  public void set_numHospitals(int numHospitals) {
    if (numHospitals == this.numHospitals) {
      return;
    }
    int _oldValue_xjal = this.numHospitals;
    this.numHospitals = numHospitals;
    onChange_numHospitals_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter numHospitals.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_numHospitals()</code> method instead.
   */
  void onChange_numHospitals() {
    onChange_numHospitals_xjal(numHospitals);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_numHospitals_xjal(int oldValue) {}

  public int numHomes;

  /**
   * Returns default value for parameter <code>numHomes</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _numHomes_DefaultValue_xjal() {
    final Main self = this;
    return 0;
  }

  public void set_numHomes(int numHomes) {
    if (numHomes == this.numHomes) {
      return;
    }
    int _oldValue_xjal = this.numHomes;
    this.numHomes = numHomes;
    onChange_numHomes_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter numHomes.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_numHomes()</code> method instead.
   */
  void onChange_numHomes() {
    onChange_numHomes_xjal(numHomes);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_numHomes_xjal(int oldValue) {}

  public int numMarkets;

  /**
   * Returns default value for parameter <code>numMarkets</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _numMarkets_DefaultValue_xjal() {
    final Main self = this;
    return 0;
  }

  public void set_numMarkets(int numMarkets) {
    if (numMarkets == this.numMarkets) {
      return;
    }
    int _oldValue_xjal = this.numMarkets;
    this.numMarkets = numMarkets;
    onChange_numMarkets_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter numMarkets.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_numMarkets()</code> method instead.
   */
  void onChange_numMarkets() {
    onChange_numMarkets_xjal(numMarkets);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_numMarkets_xjal(int oldValue) {}

  public int numSchools;

  /**
   * Returns default value for parameter <code>numSchools</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _numSchools_DefaultValue_xjal() {
    final Main self = this;
    return 0;
  }

  public void set_numSchools(int numSchools) {
    if (numSchools == this.numSchools) {
      return;
    }
    int _oldValue_xjal = this.numSchools;
    this.numSchools = numSchools;
    onChange_numSchools_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter numSchools.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_numSchools()</code> method instead.
   */
  void onChange_numSchools() {
    onChange_numSchools_xjal(numSchools);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_numSchools_xjal(int oldValue) {}

  public int numWorkplaces;

  /**
   * Returns default value for parameter <code>numWorkplaces</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _numWorkplaces_DefaultValue_xjal() {
    final Main self = this;
    return 0;
  }

  public void set_numWorkplaces(int numWorkplaces) {
    if (numWorkplaces == this.numWorkplaces) {
      return;
    }
    int _oldValue_xjal = this.numWorkplaces;
    this.numWorkplaces = numWorkplaces;
    onChange_numWorkplaces_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter numWorkplaces.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_numWorkplaces()</code> method instead.
   */
  void onChange_numWorkplaces() {
    onChange_numWorkplaces_xjal(numWorkplaces);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_numWorkplaces_xjal(int oldValue) {}

  public int numPeople;

  /**
   * Returns default value for parameter <code>numPeople</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _numPeople_DefaultValue_xjal() {
    final Main self = this;
    return 0;
  }

  public void set_numPeople(int numPeople) {
    if (numPeople == this.numPeople) {
      return;
    }
    int _oldValue_xjal = this.numPeople;
    this.numPeople = numPeople;
    onChange_numPeople_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter numPeople.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_numPeople()</code> method instead.
   */
  void onChange_numPeople() {
    onChange_numPeople_xjal(numPeople);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_numPeople_xjal(int oldValue) {}

  public int startCovid;

  /**
   * Returns default value for parameter <code>startCovid</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _startCovid_DefaultValue_xjal() {
    final Main self = this;
    return 1;
  }

  public void set_startCovid(int startCovid) {
    if (startCovid == this.startCovid) {
      return;
    }
    int _oldValue_xjal = this.startCovid;
    this.startCovid = startCovid;
    onChange_startCovid_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter startCovid.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_startCovid()</code> method instead.
   */
  void onChange_startCovid() {
    onChange_startCovid_xjal(startCovid);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_startCovid_xjal(int oldValue) {}

  public int startFlu;

  /**
   * Returns default value for parameter <code>startFlu</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _startFlu_DefaultValue_xjal() {
    final Main self = this;
    return 1;
  }

  public void set_startFlu(int startFlu) {
    if (startFlu == this.startFlu) {
      return;
    }
    int _oldValue_xjal = this.startFlu;
    this.startFlu = startFlu;
    onChange_startFlu_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter startFlu.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_startFlu()</code> method instead.
   */
  void onChange_startFlu() {
    onChange_startFlu_xjal(startFlu);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_startFlu_xjal(int oldValue) {}

  public boolean quarantine;

  /**
   * Returns default value for parameter <code>quarantine</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _quarantine_DefaultValue_xjal() {
    final Main self = this;
    return false;
  }

  public void set_quarantine(boolean quarantine) {
    if (quarantine == this.quarantine) {
      return;
    }
    boolean _oldValue_xjal = this.quarantine;
    this.quarantine = quarantine;
    onChange_quarantine_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter quarantine.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_quarantine()</code> method instead.
   */
  void onChange_quarantine() {
    onChange_quarantine_xjal(quarantine);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_quarantine_xjal(boolean oldValue) {}

  public double masks;

  /**
   * Returns default value for parameter <code>masks</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _masks_DefaultValue_xjal() {
    final Main self = this;
    return 100;
  }

  public void set_masks(double masks) {
    if (masks == this.masks) {
      return;
    }
    double _oldValue_xjal = this.masks;
    this.masks = masks;
    onChange_masks_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter masks.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_masks()</code> method instead.
   */
  void onChange_masks() {
    onChange_masks_xjal(masks);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_masks_xjal(double oldValue) {}

  public double duration;

  /**
   * Returns default value for parameter <code>duration</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _duration_DefaultValue_xjal() {
    final Main self = this;
    return 0.0;
  }

  public void set_duration(double duration) {
    if (duration == this.duration) {
      return;
    }
    double _oldValue_xjal = this.duration;
    this.duration = duration;
    onChange_duration_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter duration.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_duration()</code> method instead.
   */
  void onChange_duration() {
    onChange_duration_xjal(duration);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_duration_xjal(double oldValue) {}

  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    numHospitals = _numHospitals_DefaultValue_xjal();
    numHomes = _numHomes_DefaultValue_xjal();
    numMarkets = _numMarkets_DefaultValue_xjal();
    numSchools = _numSchools_DefaultValue_xjal();
    numWorkplaces = _numWorkplaces_DefaultValue_xjal();
    numPeople = _numPeople_DefaultValue_xjal();
    startCovid = _startCovid_DefaultValue_xjal();
    startFlu = _startFlu_DefaultValue_xjal();
    quarantine = _quarantine_DefaultValue_xjal();
    masks = _masks_DefaultValue_xjal();
    duration = _duration_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(
    String _name_xjal,
    Object _value_xjal,
    boolean _callOnChange_xjal
  ) {
    if ("numHospitals".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_numHospitals(((Number) _value_xjal).intValue());
      } else {
        numHospitals = ((Number) _value_xjal).intValue();
      }
      return true;
    }
    if ("numHomes".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_numHomes(((Number) _value_xjal).intValue());
      } else {
        numHomes = ((Number) _value_xjal).intValue();
      }
      return true;
    }
    if ("numMarkets".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_numMarkets(((Number) _value_xjal).intValue());
      } else {
        numMarkets = ((Number) _value_xjal).intValue();
      }
      return true;
    }
    if ("numSchools".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_numSchools(((Number) _value_xjal).intValue());
      } else {
        numSchools = ((Number) _value_xjal).intValue();
      }
      return true;
    }
    if ("numWorkplaces".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_numWorkplaces(((Number) _value_xjal).intValue());
      } else {
        numWorkplaces = ((Number) _value_xjal).intValue();
      }
      return true;
    }
    if ("numPeople".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_numPeople(((Number) _value_xjal).intValue());
      } else {
        numPeople = ((Number) _value_xjal).intValue();
      }
      return true;
    }
    if ("startCovid".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_startCovid(((Number) _value_xjal).intValue());
      } else {
        startCovid = ((Number) _value_xjal).intValue();
      }
      return true;
    }
    if ("startFlu".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_startFlu(((Number) _value_xjal).intValue());
      } else {
        startFlu = ((Number) _value_xjal).intValue();
      }
      return true;
    }
    if ("quarantine".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_quarantine((Boolean) _value_xjal);
      } else {
        quarantine = (Boolean) _value_xjal;
      }
      return true;
    }
    if ("masks".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_masks(((Number) _value_xjal).doubleValue());
      } else {
        masks = ((Number) _value_xjal).doubleValue();
      }
      return true;
    }
    if ("duration".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_duration(((Number) _value_xjal).doubleValue());
      } else {
        duration = ((Number) _value_xjal).doubleValue();
      }
      return true;
    }
    return super.setParameter(_name_xjal, _value_xjal, _callOnChange_xjal);
  }

  // Plain Variables

  public int nDeceasedCovid;
  public int nDeceasedFlu;
  public int nHospitalized;
  public int nSusceptibleCovid;
  public int nExposedCovid;
  public int nClinicalCovid;
  public int nMildCovid;
  public int nICUCovid;
  public int nVentilatorCovid;
  public int nRecoveredCovid;
  public int nSusceptibleFlu;
  public int nExposedFlu;
  public int nRecoveredFlu;
  public int nInfectiousFlu;
  public int capacityNHS;
  public int nClinicalFlu;
  public int nICUFlu;
  public int nAsymptomaticFlu;
  public int nInfectiousCovid;
  public int nMildFlu;
  public int nAsymptomaticCovid;
  // Events

  public EventTimeout infectFlu = new EventTimeout(this);
  public EventTimeout infectCovid = new EventTimeout(this);
  public EventTimeout endSimulation = new EventTimeout(this);

  @AnyLogicInternalCodegenAPI
  public EventTimeout _covidDead_autoUpdateEvent_xjal = new EventTimeout(this);

  @AnyLogicInternalCodegenAPI
  public EventTimeout _fluDead_autoUpdateEvent_xjal = new EventTimeout(this);

  @AnyLogicInternalCodegenAPI
  public EventTimeout _nHospitalizedStat_autoUpdateEvent_xjal = new EventTimeout(
    this
  );

  @AnyLogicInternalCodegenAPI
  public EventTimeout _covidSusceptible_autoUpdateEvent_xjal = new EventTimeout(
    this
  );

  @AnyLogicInternalCodegenAPI
  public EventTimeout _covidExposed_autoUpdateEvent_xjal = new EventTimeout(
    this
  );

  @AnyLogicInternalCodegenAPI
  public EventTimeout _covidClinical_autoUpdateEvent_xjal = new EventTimeout(
    this
  );

  @AnyLogicInternalCodegenAPI
  public EventTimeout _covidMild_autoUpdateEvent_xjal = new EventTimeout(this);

  @AnyLogicInternalCodegenAPI
  public EventTimeout _covidVentilator_autoUpdateEvent_xjal = new EventTimeout(
    this
  );

  @AnyLogicInternalCodegenAPI
  public EventTimeout _covidICU_autoUpdateEvent_xjal = new EventTimeout(this);

  @AnyLogicInternalCodegenAPI
  public EventTimeout _covidRecovered_autoUpdateEvent_xjal = new EventTimeout(
    this
  );

  @AnyLogicInternalCodegenAPI
  public EventTimeout _fluSusceptible_autoUpdateEvent_xjal = new EventTimeout(
    this
  );

  @AnyLogicInternalCodegenAPI
  public EventTimeout _fluExposed_autoUpdateEvent_xjal = new EventTimeout(this);

  @AnyLogicInternalCodegenAPI
  public EventTimeout _fluRecovered_autoUpdateEvent_xjal = new EventTimeout(
    this
  );

  @AnyLogicInternalCodegenAPI
  public EventTimeout _fluInfectious_autoUpdateEvent_xjal = new EventTimeout(
    this
  );

  @AnyLogicInternalCodegenAPI
  public EventTimeout _fluClinical_autoUpdateEvent_xjal = new EventTimeout(
    this
  );

  @AnyLogicInternalCodegenAPI
  public EventTimeout _fluICU_autoUpdateEvent_xjal = new EventTimeout(this);

  @AnyLogicInternalCodegenAPI
  public EventTimeout _fluAsymptomatic_autoUpdateEvent_xjal = new EventTimeout(
    this
  );

  @AnyLogicInternalCodegenAPI
  public EventTimeout _covidInfectious_autoUpdateEvent_xjal = new EventTimeout(
    this
  );

  @AnyLogicInternalCodegenAPI
  public EventTimeout _fluMild_autoUpdateEvent_xjal = new EventTimeout(this);

  @AnyLogicInternalCodegenAPI
  public EventTimeout _covidAsymptomatic_autoUpdateEvent_xjal = new EventTimeout(
    this
  );

  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart_flu_autoUpdateEvent_xjal = new EventTimeout(this);

  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart_covid_autoUpdateEvent_xjal = new EventTimeout(
    this
  );

  @AnyLogicInternalCodegenAPI
  public EventTimeout _Severity_autoUpdateEvent_xjal = new EventTimeout(this);

  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart1_autoUpdateEvent_xjal = new EventTimeout(this);

  @AnyLogicInternalCodegenAPI
  public EventTimeout _Severity1_autoUpdateEvent_xjal = new EventTimeout(this);

  @AnyLogicInternalCodegenAPI
  public EventTimeout _plot_autoUpdateEvent_xjal = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf(EventTimeout _e) {
    if (_e == infectFlu) return "infectFlu";
    if (_e == infectCovid) return "infectCovid";
    if (_e == endSimulation) return "endSimulation";
    if (
      _e == _covidDead_autoUpdateEvent_xjal
    ) return "covidDead auto update event";
    if (_e == _fluDead_autoUpdateEvent_xjal) return "fluDead auto update event";
    if (
      _e == _nHospitalizedStat_autoUpdateEvent_xjal
    ) return "nHospitalizedStat auto update event";
    if (
      _e == _covidSusceptible_autoUpdateEvent_xjal
    ) return "covidSusceptible auto update event";
    if (
      _e == _covidExposed_autoUpdateEvent_xjal
    ) return "covidExposed auto update event";
    if (
      _e == _covidClinical_autoUpdateEvent_xjal
    ) return "covidClinical auto update event";
    if (
      _e == _covidMild_autoUpdateEvent_xjal
    ) return "covidMild auto update event";
    if (
      _e == _covidVentilator_autoUpdateEvent_xjal
    ) return "covidVentilator auto update event";
    if (
      _e == _covidICU_autoUpdateEvent_xjal
    ) return "covidICU auto update event";
    if (
      _e == _covidRecovered_autoUpdateEvent_xjal
    ) return "covidRecovered auto update event";
    if (
      _e == _fluSusceptible_autoUpdateEvent_xjal
    ) return "fluSusceptible auto update event";
    if (
      _e == _fluExposed_autoUpdateEvent_xjal
    ) return "fluExposed auto update event";
    if (
      _e == _fluRecovered_autoUpdateEvent_xjal
    ) return "fluRecovered auto update event";
    if (
      _e == _fluInfectious_autoUpdateEvent_xjal
    ) return "fluInfectious auto update event";
    if (
      _e == _fluClinical_autoUpdateEvent_xjal
    ) return "fluClinical auto update event";
    if (_e == _fluICU_autoUpdateEvent_xjal) return "fluICU auto update event";
    if (
      _e == _fluAsymptomatic_autoUpdateEvent_xjal
    ) return "fluAsymptomatic auto update event";
    if (
      _e == _covidInfectious_autoUpdateEvent_xjal
    ) return "covidInfectious auto update event";
    if (_e == _fluMild_autoUpdateEvent_xjal) return "fluMild auto update event";
    if (
      _e == _covidAsymptomatic_autoUpdateEvent_xjal
    ) return "covidAsymptomatic auto update event";
    if (
      _e == _chart_flu_autoUpdateEvent_xjal
    ) return "chart_flu auto update event";
    if (
      _e == _chart_covid_autoUpdateEvent_xjal
    ) return "chart_covid auto update event";
    if (
      _e == _Severity_autoUpdateEvent_xjal
    ) return "Severity auto update event";
    if (_e == _chart1_autoUpdateEvent_xjal) return "chart1 auto update event";
    if (
      _e == _Severity1_autoUpdateEvent_xjal
    ) return "Severity1 auto update event";
    if (_e == _plot_autoUpdateEvent_xjal) return "plot auto update event";
    return super.getNameOf(_e);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf(EventTimeout _e) {
    if (_e == infectFlu) return EVENT_TIMEOUT_MODE_ONCE;
    if (_e == infectCovid) return EVENT_TIMEOUT_MODE_ONCE;
    if (_e == endSimulation) return EVENT_TIMEOUT_MODE_ONCE;
    if (_e == _covidDead_autoUpdateEvent_xjal) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (_e == _fluDead_autoUpdateEvent_xjal) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (
      _e == _nHospitalizedStat_autoUpdateEvent_xjal
    ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (
      _e == _covidSusceptible_autoUpdateEvent_xjal
    ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (
      _e == _covidExposed_autoUpdateEvent_xjal
    ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (
      _e == _covidClinical_autoUpdateEvent_xjal
    ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (_e == _covidMild_autoUpdateEvent_xjal) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (
      _e == _covidVentilator_autoUpdateEvent_xjal
    ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (_e == _covidICU_autoUpdateEvent_xjal) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (
      _e == _covidRecovered_autoUpdateEvent_xjal
    ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (
      _e == _fluSusceptible_autoUpdateEvent_xjal
    ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (
      _e == _fluExposed_autoUpdateEvent_xjal
    ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (
      _e == _fluRecovered_autoUpdateEvent_xjal
    ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (
      _e == _fluInfectious_autoUpdateEvent_xjal
    ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (
      _e == _fluClinical_autoUpdateEvent_xjal
    ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (_e == _fluICU_autoUpdateEvent_xjal) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (
      _e == _fluAsymptomatic_autoUpdateEvent_xjal
    ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (
      _e == _covidInfectious_autoUpdateEvent_xjal
    ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (_e == _fluMild_autoUpdateEvent_xjal) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (
      _e == _covidAsymptomatic_autoUpdateEvent_xjal
    ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (_e == _chart_flu_autoUpdateEvent_xjal) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (
      _e == _chart_covid_autoUpdateEvent_xjal
    ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (_e == _Severity_autoUpdateEvent_xjal) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (_e == _chart1_autoUpdateEvent_xjal) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (_e == _Severity1_autoUpdateEvent_xjal) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (_e == _plot_autoUpdateEvent_xjal) return EVENT_TIMEOUT_MODE_CYCLIC;
    return super.getModeOf(_e);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime(EventTimeout _e) {
    if (_e == infectFlu) return startFlu;
    if (_e == infectCovid) return startCovid;
    if (_e == endSimulation) return duration;
    if (
      _e == _covidDead_autoUpdateEvent_xjal ||
      _e == _fluDead_autoUpdateEvent_xjal ||
      _e == _nHospitalizedStat_autoUpdateEvent_xjal ||
      _e == _covidSusceptible_autoUpdateEvent_xjal ||
      _e == _covidExposed_autoUpdateEvent_xjal ||
      _e == _covidClinical_autoUpdateEvent_xjal ||
      _e == _covidMild_autoUpdateEvent_xjal ||
      _e == _covidVentilator_autoUpdateEvent_xjal ||
      _e == _covidICU_autoUpdateEvent_xjal ||
      _e == _covidRecovered_autoUpdateEvent_xjal ||
      _e == _fluSusceptible_autoUpdateEvent_xjal ||
      _e == _fluExposed_autoUpdateEvent_xjal ||
      _e == _fluRecovered_autoUpdateEvent_xjal ||
      _e == _fluInfectious_autoUpdateEvent_xjal ||
      _e == _fluClinical_autoUpdateEvent_xjal ||
      _e == _fluICU_autoUpdateEvent_xjal ||
      _e == _fluAsymptomatic_autoUpdateEvent_xjal ||
      _e == _covidInfectious_autoUpdateEvent_xjal ||
      _e == _fluMild_autoUpdateEvent_xjal ||
      _e == _covidAsymptomatic_autoUpdateEvent_xjal ||
      _e == _chart_flu_autoUpdateEvent_xjal ||
      _e == _chart_covid_autoUpdateEvent_xjal ||
      _e == _Severity_autoUpdateEvent_xjal ||
      _e == _chart1_autoUpdateEvent_xjal ||
      _e == _Severity1_autoUpdateEvent_xjal ||
      _e == _plot_autoUpdateEvent_xjal
    ) return getEngine().getStartTime();
    return super.getFirstOccurrenceTime(_e);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double evaluateTimeoutOf(EventTimeout _e) {
    if (_e == _covidDead_autoUpdateEvent_xjal) return 1;
    if (_e == _fluDead_autoUpdateEvent_xjal) return 1;
    if (_e == _nHospitalizedStat_autoUpdateEvent_xjal) return 0.1;
    if (_e == _covidSusceptible_autoUpdateEvent_xjal) return 1;
    if (_e == _covidExposed_autoUpdateEvent_xjal) return 1;
    if (_e == _covidClinical_autoUpdateEvent_xjal) return 1;
    if (_e == _covidMild_autoUpdateEvent_xjal) return 1;
    if (_e == _covidVentilator_autoUpdateEvent_xjal) return 1;
    if (_e == _covidICU_autoUpdateEvent_xjal) return 1;
    if (_e == _covidRecovered_autoUpdateEvent_xjal) return 1;
    if (_e == _fluSusceptible_autoUpdateEvent_xjal) return 1;
    if (_e == _fluExposed_autoUpdateEvent_xjal) return 1;
    if (_e == _fluRecovered_autoUpdateEvent_xjal) return 1;
    if (_e == _fluInfectious_autoUpdateEvent_xjal) return 1;
    if (_e == _fluClinical_autoUpdateEvent_xjal) return 1;
    if (_e == _fluICU_autoUpdateEvent_xjal) return 1;
    if (_e == _fluAsymptomatic_autoUpdateEvent_xjal) return 1;
    if (_e == _covidInfectious_autoUpdateEvent_xjal) return 1;
    if (_e == _fluMild_autoUpdateEvent_xjal) return 1;
    if (_e == _covidAsymptomatic_autoUpdateEvent_xjal) return 1;
    if (_e == _chart_flu_autoUpdateEvent_xjal) return 0.1;
    if (_e == _chart_covid_autoUpdateEvent_xjal) return 0.1;
    if (_e == _Severity_autoUpdateEvent_xjal) return 1;
    if (_e == _chart1_autoUpdateEvent_xjal) return 0.1;
    if (_e == _Severity1_autoUpdateEvent_xjal) return 1;
    if (_e == _plot_autoUpdateEvent_xjal) return 0.1;
    return super.evaluateTimeoutOf(_e);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf(EventTimeout _e) {
    if (_e == infectFlu) {
      EventTimeout self = _e;

      for (int i = 0; i < 3; i++) {
        people
          .get(uniform_discr(people.size() - 1))
          .flu_progression.receiveMessage("flu");
      }
      return;
    }
    if (_e == infectCovid) {
      EventTimeout self = _e;

      for (int i = 0; i <= 3; i++) {
        people
          .get(uniform_discr(people.size() - 1))
          .covid_progression.receiveMessage("covid");
      }
      return;
    }
    if (_e == endSimulation) {
      EventTimeout self = _e;

      saveResults();
      if (closeFileWindow.isVisible() == false) {
        getExperiment().stop();
      }
      return;
    }
    if (_e == _covidDead_autoUpdateEvent_xjal) {
      covidDead.update();
      return;
    }
    if (_e == _fluDead_autoUpdateEvent_xjal) {
      fluDead.update();
      return;
    }
    if (_e == _nHospitalizedStat_autoUpdateEvent_xjal) {
      nHospitalizedStat.update();
      return;
    }
    if (_e == _covidSusceptible_autoUpdateEvent_xjal) {
      covidSusceptible.update();
      return;
    }
    if (_e == _covidExposed_autoUpdateEvent_xjal) {
      covidExposed.update();
      return;
    }
    if (_e == _covidClinical_autoUpdateEvent_xjal) {
      covidClinical.update();
      return;
    }
    if (_e == _covidMild_autoUpdateEvent_xjal) {
      covidMild.update();
      return;
    }
    if (_e == _covidVentilator_autoUpdateEvent_xjal) {
      covidVentilator.update();
      return;
    }
    if (_e == _covidICU_autoUpdateEvent_xjal) {
      covidICU.update();
      return;
    }
    if (_e == _covidRecovered_autoUpdateEvent_xjal) {
      covidRecovered.update();
      return;
    }
    if (_e == _fluSusceptible_autoUpdateEvent_xjal) {
      fluSusceptible.update();
      return;
    }
    if (_e == _fluExposed_autoUpdateEvent_xjal) {
      fluExposed.update();
      return;
    }
    if (_e == _fluRecovered_autoUpdateEvent_xjal) {
      fluRecovered.update();
      return;
    }
    if (_e == _fluInfectious_autoUpdateEvent_xjal) {
      fluInfectious.update();
      return;
    }
    if (_e == _fluClinical_autoUpdateEvent_xjal) {
      fluClinical.update();
      return;
    }
    if (_e == _fluICU_autoUpdateEvent_xjal) {
      fluICU.update();
      return;
    }
    if (_e == _fluAsymptomatic_autoUpdateEvent_xjal) {
      fluAsymptomatic.update();
      return;
    }
    if (_e == _covidInfectious_autoUpdateEvent_xjal) {
      covidInfectious.update();
      return;
    }
    if (_e == _fluMild_autoUpdateEvent_xjal) {
      fluMild.update();
      return;
    }
    if (_e == _covidAsymptomatic_autoUpdateEvent_xjal) {
      covidAsymptomatic.update();
      return;
    }
    if (_e == _chart_flu_autoUpdateEvent_xjal) {
      chart_flu.updateData();
      return;
    }
    if (_e == _chart_covid_autoUpdateEvent_xjal) {
      chart_covid.updateData();
      return;
    }
    if (_e == _Severity_autoUpdateEvent_xjal) {
      Severity.updateData();
      return;
    }
    if (_e == _chart1_autoUpdateEvent_xjal) {
      chart1.updateData();
      return;
    }
    if (_e == _Severity1_autoUpdateEvent_xjal) {
      Severity1.updateData();
      return;
    }
    if (_e == _plot_autoUpdateEvent_xjal) {
      plot.updateData();
      return;
    }
    super.executeActionOf(_e);
  }

  // Dynamic Events

  /**
   * Creates new dynamic event pauseSimulation with given parameter values and schedules in the timeout specified
   * @param _dt_xjal the timeout
   * @return created dynamic event instance
   */
  public pauseSimulation create_pauseSimulation(double _dt_xjal) {
    return new pauseSimulation(this, _dt_xjal);
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public void on_pauseSimulation_xjal() {
    this.pauseSimulation();
  }

  /**
   * Creates new dynamic event startSimulation with given parameter values and schedules in the timeout specified
   * @param _dt_xjal the timeout
   * @return created dynamic event instance
   */
  public startSimulation create_startSimulation(double _dt_xjal) {
    return new startSimulation(this, _dt_xjal);
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public void on_startSimulation_xjal() {
    this.runSimulation();
  }

  /**
   * Creates new dynamic event infectEvent with given parameter values and schedules in the timeout specified
   * @param _dt_xjal the timeout
   * @return created dynamic event instance
   */
  public infectEvent create_infectEvent(double _dt_xjal) {
    return new infectEvent(this, _dt_xjal);
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public void on_infectEvent_xjal() {
    send("flu", people.random());
    send("covid", people.random());
  }

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final short _STATECHART_ELEMENT_NEXT_ID_xjal = 0;

  // Embedded Objects

  public String getNameOf(Agent ao) {
    return super.getNameOf(ao);
  }

  public class _homes_Class extends AgentArrayList<Home> {

    _homes_Class(Agent owner) {
      super(owner);
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters(Home agent, int index) {
      setupParameters_homes_xjal(agent, index);
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate(Home agent, int index) {
      create_homes_xjal(agent, index);
    }

    /**
     * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
     */
    @AnyLogicInternalCodegenAPI
    private static final long serialVersionUID = 2497856771812684463L;
  }

  public _homes_Class homes = new _homes_Class(this);

  public class _hospitals_Class extends AgentArrayList<Hospital> {

    _hospitals_Class(Agent owner) {
      super(owner);
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters(Hospital agent, int index) {
      setupParameters_hospitals_xjal(agent, index);
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate(Hospital agent, int index) {
      create_hospitals_xjal(agent, index);
    }

    /**
     * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
     */
    @AnyLogicInternalCodegenAPI
    private static final long serialVersionUID = 2497856771812734718L;
  }

  public _hospitals_Class hospitals = new _hospitals_Class(this);

  public class _markets_Class extends AgentArrayList<SocialPlace> {

    _markets_Class(Agent owner) {
      super(owner);
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters(SocialPlace agent, int index) {
      setupParameters_markets_xjal(agent, index);
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate(SocialPlace agent, int index) {
      create_markets_xjal(agent, index);
    }

    /**
     * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
     */
    @AnyLogicInternalCodegenAPI
    private static final long serialVersionUID = 2497856771812751023L;
  }

  public _markets_Class markets = new _markets_Class(this);

  public class _people_Class extends AgentLinkedHashSet<Person> {

    _people_Class(Agent owner) {
      super(owner);
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters(Person agent, int index) {
      setupParameters_people_xjal(agent, index);
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate(Person agent, int index) {
      create_people_xjal(agent, index);
    }

    public int twinfected() {
      return _people_twinfected_xjal();
    }

    public int double_hospital() {
      return _people_double_hospital_xjal();
    }

    public int hospital_flu() {
      return _people_hospital_flu_xjal();
    }

    public int hospital_covid() {
      return _people_hospital_covid_xjal();
    }

    /**
     * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
     */
    @AnyLogicInternalCodegenAPI
    private static final long serialVersionUID = 2497856771812927150L;
  }

  public _people_Class people = new _people_Class(this);

  public class _schools_Class extends AgentArrayList<School> {

    _schools_Class(Agent owner) {
      super(owner);
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters(School agent, int index) {
      setupParameters_schools_xjal(agent, index);
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate(School agent, int index) {
      create_schools_xjal(agent, index);
    }

    /**
     * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
     */
    @AnyLogicInternalCodegenAPI
    private static final long serialVersionUID = 2497856771812926399L;
  }

  public _schools_Class schools = new _schools_Class(this);

  public class _workplaces_Class extends AgentArrayList<Workplace> {

    _workplaces_Class(Agent owner) {
      super(owner);
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters(Workplace agent, int index) {
      setupParameters_workplaces_xjal(agent, index);
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate(Workplace agent, int index) {
      create_workplaces_xjal(agent, index);
    }

    /**
     * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
     */
    @AnyLogicInternalCodegenAPI
    private static final long serialVersionUID = 2497856771812947707L;
  }

  public _workplaces_Class workplaces = new _workplaces_Class(this);

  public String getNameOf(AgentList<?> aolist) {
    if (aolist == homes) return "homes";
    if (aolist == hospitals) return "hospitals";
    if (aolist == markets) return "markets";
    if (aolist == people) return "people";
    if (aolist == schools) return "schools";
    if (aolist == workplaces) return "workplaces";
    return super.getNameOf(aolist);
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection homes<br>
   * @return newly created embedded object
   */
  public Home add_homes() {
    int index = homes.size();
    Home _result_xjal = instantiate_homes_xjal(index);
    homes.callSetupParameters(_result_xjal, index);
    homes.callCreate(_result_xjal, index);
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection homes<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object homes - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to homes
   */
  public boolean remove_homes(Home object) {
    if (!homes._remove(object)) {
      return false;
    }
    object.setDestroyed();
    return true;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection hospitals<br>
   * @return newly created embedded object
   */
  public Hospital add_hospitals() {
    int index = hospitals.size();
    Hospital _result_xjal = instantiate_hospitals_xjal(index);
    hospitals.callSetupParameters(_result_xjal, index);
    hospitals.callCreate(_result_xjal, index);
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection hospitals<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object hospitals - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to hospitals
   */
  public boolean remove_hospitals(Hospital object) {
    if (!hospitals._remove(object)) {
      return false;
    }
    object.setDestroyed();
    return true;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection markets<br>
   * @return newly created embedded object
   */
  public SocialPlace add_markets() {
    int index = markets.size();
    SocialPlace _result_xjal = instantiate_markets_xjal(index);
    markets.callSetupParameters(_result_xjal, index);
    markets.callCreate(_result_xjal, index);
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection markets<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object markets - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to markets
   */
  public boolean remove_markets(SocialPlace object) {
    if (!markets._remove(object)) {
      return false;
    }
    object.setDestroyed();
    return true;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection people<br>
   * @return newly created embedded object
   */
  public Person add_people() {
    int index = people.size();
    Person _result_xjal = instantiate_people_xjal(index);
    people.callSetupParameters(_result_xjal, index);
    people.callCreate(_result_xjal, index);
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection people<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>people.size()</code> method <strong>before</strong> this method is called
   * @param agentHome
   * @param agentSchool
   * @param agentWorkplace
   * @param agentAge
   * @param socialActivityStyle
   * @param isAvailable
   * @param numFriends
   * @param covidInfectionProbability
   * @param covidClinicalRate
   * @param covidICURate
   * @param fluInfectionProbability
   * @param atRiskFromCovid
   * @param covidChronicRisk
   * @param fluClinicalRate
   * @param atRiskFromFlu
   * @param fluChronicRisk
   * @param fluICURate
   * @param fluDangerFactor
   * @param covidDangerFactor
   * @return newly created embedded object
   */
  public Person add_people(
    Home agentHome,
    School agentSchool,
    Workplace agentWorkplace,
    int agentAge,
    SocialActivity socialActivityStyle,
    boolean isAvailable,
    int numFriends,
    double covidInfectionProbability,
    double covidClinicalRate,
    double covidICURate,
    double fluInfectionProbability,
    boolean atRiskFromCovid,
    double covidChronicRisk,
    double fluClinicalRate,
    boolean atRiskFromFlu,
    double fluChronicRisk,
    double fluICURate,
    double fluDangerFactor,
    double covidDangerFactor
  ) {
    int index = people.size();
    Person _result_xjal = instantiate_people_xjal(index);
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.agentHome = agentHome;
    _result_xjal.agentSchool = agentSchool;
    _result_xjal.agentWorkplace = agentWorkplace;
    _result_xjal.agentAge = agentAge;
    _result_xjal.socialActivityStyle = socialActivityStyle;
    _result_xjal.isAvailable = isAvailable;
    _result_xjal.numFriends = numFriends;
    _result_xjal.covidInfectionProbability = covidInfectionProbability;
    _result_xjal.covidClinicalRate = covidClinicalRate;
    _result_xjal.covidICURate = covidICURate;
    _result_xjal.fluInfectionProbability = fluInfectionProbability;
    _result_xjal.atRiskFromCovid = atRiskFromCovid;
    _result_xjal.covidChronicRisk = covidChronicRisk;
    _result_xjal.fluClinicalRate = fluClinicalRate;
    _result_xjal.atRiskFromFlu = atRiskFromFlu;
    _result_xjal.fluChronicRisk = fluChronicRisk;
    _result_xjal.fluICURate = fluICURate;
    _result_xjal.fluDangerFactor = fluDangerFactor;
    _result_xjal.covidDangerFactor = covidDangerFactor;
    // Finish embedded object creation
    people.callCreate(_result_xjal, index);
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection people<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object people - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to people
   */
  public boolean remove_people(Person object) {
    if (!people._remove(object)) {
      return false;
    }
    object.setDestroyed();
    return true;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection schools<br>
   * @return newly created embedded object
   */
  public School add_schools() {
    int index = schools.size();
    School _result_xjal = instantiate_schools_xjal(index);
    schools.callSetupParameters(_result_xjal, index);
    schools.callCreate(_result_xjal, index);
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection schools<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object schools - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to schools
   */
  public boolean remove_schools(School object) {
    if (!schools._remove(object)) {
      return false;
    }
    object.setDestroyed();
    return true;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection workplaces<br>
   * @return newly created embedded object
   */
  public Workplace add_workplaces() {
    int index = workplaces.size();
    Workplace _result_xjal = instantiate_workplaces_xjal(index);
    workplaces.callSetupParameters(_result_xjal, index);
    workplaces.callCreate(_result_xjal, index);
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection workplaces<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object workplaces - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to workplaces
   */
  public boolean remove_workplaces(Workplace object) {
    if (!workplaces._remove(object)) {
      return false;
    }
    object.setDestroyed();
    return true;
  }

  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected Home instantiate_homes_xjal(final int index) {
    Home _result_xjal = new Home(getEngine(), this, homes);

    homes._add(_result_xjal);

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_homes_xjal(final Home self, final int index) {}

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  private void create_homes_xjal(Home self, final int index) {
    self.setEnvironment(this);
    self.create();
    // Port connections
  }

  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected Hospital instantiate_hospitals_xjal(final int index) {
    Hospital _result_xjal = new Hospital(getEngine(), this, hospitals);

    hospitals._add(_result_xjal);

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_hospitals_xjal(
    final Hospital self,
    final int index
  ) {}

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  private void create_hospitals_xjal(Hospital self, final int index) {
    self.setEnvironment(this);
    self.create();
    // Port connections
  }

  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected SocialPlace instantiate_markets_xjal(final int index) {
    SocialPlace _result_xjal = new SocialPlace(getEngine(), this, markets);

    markets._add(_result_xjal);

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_markets_xjal(
    final SocialPlace self,
    final int index
  ) {}

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  private void create_markets_xjal(SocialPlace self, final int index) {
    self.setEnvironment(this);
    self.create();
    // Port connections
  }

  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected Person instantiate_people_xjal(final int index) {
    Person _result_xjal = new Person(getEngine(), this, people);

    people._add(_result_xjal);

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_people_xjal(final Person self, final int index) {
    self.agentHome = self._agentHome_DefaultValue_xjal();
    self.agentSchool = self._agentSchool_DefaultValue_xjal();
    self.agentWorkplace = self._agentWorkplace_DefaultValue_xjal();
    self.agentAge = (int) uniform(0, 90);
    self.socialActivityStyle = socialDistribution();
    self.isAvailable = self._isAvailable_DefaultValue_xjal();
    self.numFriends = self._numFriends_DefaultValue_xjal();
    self.covidInfectionProbability =
      self._covidInfectionProbability_DefaultValue_xjal();
    self.covidClinicalRate = self._covidClinicalRate_DefaultValue_xjal();
    self.covidICURate = self._covidICURate_DefaultValue_xjal();
    self.fluInfectionProbability =
      self._fluInfectionProbability_DefaultValue_xjal();
    self.atRiskFromCovid = self._atRiskFromCovid_DefaultValue_xjal();
    self.covidChronicRisk = self._covidChronicRisk_DefaultValue_xjal();
    self.fluClinicalRate = self._fluClinicalRate_DefaultValue_xjal();
    self.atRiskFromFlu = self._atRiskFromFlu_DefaultValue_xjal();
    self.fluChronicRisk = self._fluChronicRisk_DefaultValue_xjal();
    self.fluICURate = self._fluICURate_DefaultValue_xjal();
    self.fluDangerFactor = self._fluDangerFactor_DefaultValue_xjal();
    self.covidDangerFactor = self._covidDangerFactor_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  private void create_people_xjal(Person self, final int index) {
    self.setEnvironment(this);
    self.create();
    // Port connections
  }

  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected School instantiate_schools_xjal(final int index) {
    School _result_xjal = new School(getEngine(), this, schools);

    schools._add(_result_xjal);

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_schools_xjal(
    final School self,
    final int index
  ) {}

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  private void create_schools_xjal(School self, final int index) {
    self.setEnvironment(this);
    self.create();
    // Port connections
  }

  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected Workplace instantiate_workplaces_xjal(final int index) {
    Workplace _result_xjal = new Workplace(getEngine(), this, workplaces);

    workplaces._add(_result_xjal);

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_workplaces_xjal(
    final Workplace self,
    final int index
  ) {}

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  private void create_workplaces_xjal(Workplace self, final int index) {
    self.setEnvironment(this);
    self.create();
    // Port connections
  }

  /**
   * <i>This method should not be called by user</i>
   */
  private int _people_twinfected_xjal() {
    int _value = 0;
    for (Person item : people) {
      boolean _t = item.factor != 1;
      if (_t) {
        _value++;
      }
    }
    return _value;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  private int _people_double_hospital_xjal() {
    int _value = 0;
    for (Person item : people) {
      boolean _t =
        item.hospitalizedFlu == true && item.hospitalizedCovid == true;
      if (_t) {
        _value++;
      }
    }
    return _value;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  private int _people_hospital_flu_xjal() {
    int _value = 0;
    for (Person item : people) {
      boolean _t = item.hospitalizedFlu == true;
      if (_t) {
        _value++;
      }
    }
    return _value;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  private int _people_hospital_covid_xjal() {
    int _value = 0;
    for (Person item : people) {
      boolean _t = item.hospitalizedCovid == true;
      if (_t) {
        _value++;
      }
    }
    return _value;
  }

  // Functions

  void saveResults() {
    try {
      if (closeFileWindow.isVisible() == false) {
        int col = resultsFile.getLastCellNum("SimulationParameters", 1);
        int lastRun;
        try {
          lastRun =
            (int) resultsFile.getCellNumericValue(
              "SimulationParameters",
              1,
              col
            );
        } catch (IllegalStateException e) {
          lastRun = 0;
        }
        //save run numbers
        resultsFile.createCell("SimulationParameters", 1, col + 1);
        resultsFile.setCellValue(
          lastRun + 1,
          "SimulationParameters",
          1,
          col + 1
        );
        resultsFile.createCell("Flu", 1, col + 1);
        resultsFile.setCellValue(lastRun + 1, "Flu", 1, col + 1);
        resultsFile.createCell("Covid-19", 1, col + 1);
        resultsFile.setCellValue(lastRun + 1, "Covid-19", 1, col + 1);
        resultsFile.createCell("Statistics", 1, col + 1);
        resultsFile.setCellValue(lastRun + 1, "Statistics", 1, col + 1);
        //save model parameters
        resultsFile.createCell("SimulationParameters", 2, col + 1);
        resultsFile.setCellValue(
          this.numHomes,
          "SimulationParameters",
          2,
          col + 1
        );
        resultsFile.createCell("SimulationParameters", 3, col + 1);
        resultsFile.setCellValue(
          this.numHospitals,
          "SimulationParameters",
          3,
          col + 1
        );
        resultsFile.createCell("SimulationParameters", 4, col + 1);
        resultsFile.setCellValue(
          this.numMarkets,
          "SimulationParameters",
          4,
          col + 1
        );
        resultsFile.createCell("SimulationParameters", 5, col + 1);
        resultsFile.setCellValue(
          this.numSchools,
          "SimulationParameters",
          5,
          col + 1
        );
        resultsFile.createCell("SimulationParameters", 6, col + 1);
        resultsFile.setCellValue(
          this.numWorkplaces,
          "SimulationParameters",
          6,
          col + 1
        );
        resultsFile.createCell("SimulationParameters", 7, col + 1);
        resultsFile.setCellValue(
          this.people.size(),
          "SimulationParameters",
          7,
          col + 1
        );
        resultsFile.createCell("SimulationParameters", 8, col + 1);
        resultsFile.setCellValue(
          this.startFlu,
          "SimulationParameters",
          8,
          col + 1
        );
        resultsFile.createCell("SimulationParameters", 9, col + 1);
        resultsFile.setCellValue(
          this.startCovid,
          "SimulationParameters",
          9,
          col + 1
        );
        //save Flu data
        resultsFile.createCell("Flu", 2, col + 1);
        resultsFile.setCellValue(nSusceptibleFlu, "Flu", 2, col + 1);
        resultsFile.createCell("Flu", 3, col + 1);
        resultsFile.setCellValue(nExposedFlu, "Flu", 3, col + 1);
        resultsFile.createCell("Flu", 4, col + 1);
        resultsFile.setCellValue(nInfectiousFlu, "Flu", 4, col + 1);
        resultsFile.createCell("Flu", 5, col + 1);
        resultsFile.setCellValue(nAsymptomaticFlu, "Flu", 5, col + 1);
        resultsFile.createCell("Flu", 6, col + 1);
        resultsFile.setCellValue(nMildFlu, "Flu", 6, col + 1);
        resultsFile.createCell("Flu", 7, col + 1);
        resultsFile.setCellValue(nClinicalFlu, "Flu", 7, col + 1);
        resultsFile.createCell("Flu", 8, col + 1);
        resultsFile.setCellValue(nICUFlu, "Flu", 8, col + 1);
        resultsFile.createCell("Flu", 9, col + 1);
        resultsFile.setCellValue(nRecoveredFlu, "Flu", 9, col + 1);
        resultsFile.createCell("Flu", 10, col + 1);
        resultsFile.setCellValue(nDeceasedFlu, "Flu", 10, col + 1);
        //save Covid data
        resultsFile.createCell("Covid-19", 2, col + 1);
        resultsFile.setCellValue(nSusceptibleCovid, "Covid-19", 2, col + 1);
        resultsFile.createCell("Covid-19", 3, col + 1);
        resultsFile.setCellValue(nExposedCovid, "Covid-19", 3, col + 1);
        resultsFile.createCell("Covid-19", 4, col + 1);
        resultsFile.setCellValue(nInfectiousCovid, "Covid-19", 4, col + 1);
        resultsFile.createCell("Covid-19", 5, col + 1);
        resultsFile.setCellValue(nAsymptomaticCovid, "Covid-19", 5, col + 1);
        resultsFile.createCell("Covid-19", 6, col + 1);
        resultsFile.setCellValue(nMildCovid, "Covid-19", 6, col + 1);
        resultsFile.createCell("Covid-19", 7, col + 1);
        resultsFile.setCellValue(nClinicalCovid, "Covid-19", 7, col + 1);
        resultsFile.createCell("Covid-19", 8, col + 1);
        resultsFile.setCellValue(nICUCovid, "Covid-19", 8, col + 1);
        resultsFile.createCell("Covid-19", 9, col + 1);
        resultsFile.setCellValue(nVentilatorCovid, "Covid-19", 9, col + 1);
        resultsFile.createCell("Covid-19", 10, col + 1);
        resultsFile.setCellValue(nRecoveredCovid, "Covid-19", 10, col + 1);
        resultsFile.createCell("Covid-19", 11, col + 1);
        resultsFile.setCellValue(nDeceasedCovid, "Covid-19", 11, col + 1);
        //save Statistics
        double twinfected = this.people.twinfected();
        resultsFile.createCell("Statistics", 2, col + 1);
        resultsFile.setCellValue(twinfected, "Statistics", 2, col + 1);
        int beds =
          this.people.hospital_covid() +
          this.people.hospital_flu() -
          2 *
          this.people.double_hospital();
        resultsFile.createCell("Statistics", 3, col + 1);
        resultsFile.setCellValue(beds, "Statistics", 3, col + 1);
        resultsFile.createCell("Statistics", 4, col + 1);
        resultsFile.setCellValue(capacityNHS, "Statistics", 4, col + 1);
        resultsFile.createCell("Statistics", 5, col + 1);
        Double time = Double.valueOf(this.getEngine().time());
        resultsFile.setCellValue(time, "Statistics", 5, col + 1);

        resultsFile.writeFile();
      }
    } catch (RuntimeException e) {
      closeFileWindow.setVisible(true);
    }
  }

  // Custom Distributions

  @AnyLogicInternalCodegenAPI
  private static final SocialActivity[] _socialDistribution_Arguments_xjal = _socialDistribution_Arguments_xjal();

  @AnyLogicInternalCodegenAPI
  private static final SocialActivity[] _socialDistribution_Arguments_xjal() {
    return new SocialActivity[] {
      SocialActivity.MoreThanOnceWeekly,
      SocialActivity.OnceWeekly,
      SocialActivity.OnceMonthly,
    };
  }

  @AnyLogicInternalCodegenAPI
  private static final double[] _socialDistribution_Values_xjal = _socialDistribution_Values_xjal();

  @AnyLogicInternalCodegenAPI
  private static final double[] _socialDistribution_Values_xjal() {
    return new double[] { 47.0, 43.0, 10.0 };
  }

  /**
   * socialDistribution Custom Distribution
   */
  public CustomDistributionOfOptions<SocialActivity> socialDistribution = new CustomDistributionOfOptions<SocialActivity>(
    _socialDistribution_Arguments_xjal,
    _socialDistribution_Values_xjal,
    this
  );

  public SocialActivity socialDistribution() {
    return socialDistribution.get();
  }

  // Analysis Data Elements
  @AnyLogicInternalCodegenAPI
  public DataSet _plot_expression0_dataSet_xjal = new DataSet(
    1000,
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(DataSet _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(time(), __plot_expression0_dataSet_xjal_YValue());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856770671096810L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot_expression0_dataSet_xjal_YValue() {
    return nAsymptomaticFlu + nClinicalFlu + nICUFlu + nMildFlu;
  }

  @AnyLogicInternalCodegenAPI
  public DataSet _plot_expression1_dataSet_xjal = new DataSet(
    1000,
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(DataSet _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(time(), __plot_expression1_dataSet_xjal_YValue());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856770671096810L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot_expression1_dataSet_xjal_YValue() {
    return (
      nClinicalCovid +
      nMildCovid +
      nICUCovid +
      nVentilatorCovid +
      nAsymptomaticCovid
    );
  }

  public StatisticsDiscrete covidDead = new StatisticsDiscrete(
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(StatisticsDiscrete _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(_covidDead_Value());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856749519943406L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _covidDead_Value() {
    return nDeceasedCovid;
  }

  public StatisticsDiscrete fluDead = new StatisticsDiscrete(
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(StatisticsDiscrete _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(_fluDead_Value());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856749520007851L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _fluDead_Value() {
    return nDeceasedFlu;
  }

  public StatisticsDiscrete nHospitalizedStat = new StatisticsDiscrete(
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(StatisticsDiscrete _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(_nHospitalizedStat_Value());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856749453173739L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _nHospitalizedStat_Value() {
    return nHospitalized;
  }

  public StatisticsDiscrete covidSusceptible = new StatisticsDiscrete(
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(StatisticsDiscrete _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(_covidSusceptible_Value());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856749447657195L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _covidSusceptible_Value() {
    return nSusceptibleCovid;
  }

  public StatisticsDiscrete covidExposed = new StatisticsDiscrete(
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(StatisticsDiscrete _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(_covidExposed_Value());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856749447657199L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _covidExposed_Value() {
    return nExposedCovid;
  }

  public StatisticsDiscrete covidClinical = new StatisticsDiscrete(
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(StatisticsDiscrete _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(_covidClinical_Value());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856749447668670L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _covidClinical_Value() {
    return nClinicalCovid;
  }

  public StatisticsDiscrete covidMild = new StatisticsDiscrete(
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(StatisticsDiscrete _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(_covidMild_Value());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856749447668650L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _covidMild_Value() {
    return nMildCovid;
  }

  public StatisticsDiscrete covidVentilator = new StatisticsDiscrete(
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(StatisticsDiscrete _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(_covidVentilator_Value());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856749447848703L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _covidVentilator_Value() {
    return nVentilatorCovid;
  }

  public StatisticsDiscrete covidICU = new StatisticsDiscrete(
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(StatisticsDiscrete _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(_covidICU_Value());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856749447848875L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _covidICU_Value() {
    return nICUCovid;
  }

  public StatisticsDiscrete covidRecovered = new StatisticsDiscrete(
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(StatisticsDiscrete _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(_covidRecovered_Value());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856749447934910L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _covidRecovered_Value() {
    return nRecoveredCovid;
  }

  public StatisticsDiscrete fluSusceptible = new StatisticsDiscrete(
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(StatisticsDiscrete _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(_fluSusceptible_Value());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856749447606970L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _fluSusceptible_Value() {
    return nSusceptibleFlu;
  }

  public StatisticsDiscrete fluExposed = new StatisticsDiscrete(
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(StatisticsDiscrete _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(_fluExposed_Value());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856749447606974L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _fluExposed_Value() {
    return nExposedFlu;
  }

  public StatisticsDiscrete fluRecovered = new StatisticsDiscrete(
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(StatisticsDiscrete _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(_fluRecovered_Value());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856749447653370L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _fluRecovered_Value() {
    return nRecoveredFlu;
  }

  public StatisticsDiscrete fluInfectious = new StatisticsDiscrete(
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(StatisticsDiscrete _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(_fluInfectious_Value());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856749447865278L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _fluInfectious_Value() {
    return nInfectiousFlu;
  }

  public StatisticsDiscrete fluClinical = new StatisticsDiscrete(
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(StatisticsDiscrete _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(_fluClinical_Value());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856749197047482L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _fluClinical_Value() {
    return nClinicalFlu;
  }

  public StatisticsDiscrete fluICU = new StatisticsDiscrete(
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(StatisticsDiscrete _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(_fluICU_Value());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856749197047482L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _fluICU_Value() {
    return nRecoveredFlu;
  }

  public StatisticsDiscrete fluAsymptomatic = new StatisticsDiscrete(
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(StatisticsDiscrete _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(_fluAsymptomatic_Value());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856749197047486L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _fluAsymptomatic_Value() {
    return nAsymptomaticFlu;
  }

  public DataSet twinfectedDS = new DataSet(
    100,
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(DataSet _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(time(), _twinfectedDS_YValue());
        _lastUpdateX = time();
      }

      @Override
      public double getDataXValue() {
        return time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856749247636143L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _twinfectedDS_YValue() {
    return people.twinfected();
  }

  public StatisticsDiscrete covidInfectious = new StatisticsDiscrete(
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(StatisticsDiscrete _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(_covidInfectious_Value());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856750338106090L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _covidInfectious_Value() {
    return nInfectiousCovid;
  }

  public StatisticsDiscrete fluMild = new StatisticsDiscrete(
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(StatisticsDiscrete _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(_fluMild_Value());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856750253241066L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _fluMild_Value() {
    return nMildFlu;
  }

  public StatisticsDiscrete covidAsymptomatic = new StatisticsDiscrete(
    new DataUpdater_xjal() {
      double _lastUpdateX = Double.NaN;

      @Override
      public void update(StatisticsDiscrete _d) {
        if (time() == _lastUpdateX) {
          return;
        }
        _d.add(_covidAsymptomatic_Value());
        _lastUpdateX = time();
      }

      /**
       * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
       */
      @AnyLogicInternalCodegenAPI
      private static final long serialVersionUID = 2497856750258221999L;
    }
  );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _covidAsymptomatic_Value() {
    return nAsymptomaticCovid;
  }

  // View areas
  public ViewArea observatoryViewArea = new ViewArea(
    this,
    null,
    0,
    0,
    ViewArea.TOP_LEFT,
    ViewArea.ZOOM_TO_FIT,
    1.0,
    1500,
    800
  );
  public ViewArea _origin_VA = new ViewArea(
    this,
    "[Origin]",
    0,
    0,
    ViewArea.TOP_LEFT,
    ViewArea.SPECIFIED_ZOOM,
    1,
    100,
    100
  );

  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if (_output != null) {
      _output.put("observatoryViewArea", this.observatoryViewArea);
      _output.put("_origin_VA", this._origin_VA);
    }
    return 2 + super.getViewAreas(_output);
  }

  @AnyLogicInternalCodegenAPI
  protected static final Font _pauseButton1_Font = new Font("Arial", 0, 20);

  @AnyLogicInternalCodegenAPI
  protected static final Font _startButton1_Font = _pauseButton1_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _stopButton1_Font = _pauseButton1_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_Font = new Font("Arial", 0, 16);

  @AnyLogicInternalCodegenAPI
  protected static final Font _button1_Font = new Font("Dialog", 1, 20);

  @AnyLogicInternalCodegenAPI
  protected static final Font _text_Font = _checkbox_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text1_Font = _checkbox_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text2_Font = _checkbox_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text3_Font = new Font("Arial", 1, 16);

  @AnyLogicInternalCodegenAPI
  protected static final Font _text7_Font = _text3_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text8_Font = _text3_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text4_Font = _checkbox_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text5_Font = _checkbox_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text6_Font = _checkbox_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text9_Font = _checkbox_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text10_Font = _checkbox_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text11_Font = _checkbox_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text12_Font = _text3_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text13_Font = _text3_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text14_Font = _pauseButton1_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text15_Font = _text3_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text16_Font = _checkbox_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text17_Font = _text3_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text19_Font = _checkbox_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text20_Font = _checkbox_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text18_Font = new Font("SansSerif", 0, 24);

  @AnyLogicInternalCodegenAPI
  protected static final Font _text21_Font = _text3_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text22_Font = new Font("Arial", 0, 14);

  @AnyLogicInternalCodegenAPI
  protected static final Font _text23_Font = new Font("Arial", 0, 12);

  @AnyLogicInternalCodegenAPI
  protected static final Font _text24_Font = _text23_Font;

  @AnyLogicInternalCodegenAPI
  protected static final Font _text25_Font = _text23_Font;

  protected static final Color _pauseButton1_Fill_Color = new Color(
    0xFFECECFB,
    true
  );
  protected static final Color _startButton1_Fill_Color = new Color(
    0xFFECECFB,
    true
  );
  protected static final Color _stopButton1_Fill_Color = new Color(
    0xFFECECFB,
    true
  );
  protected static final Color _roundRectangle_Fill_Color = new Color(
    0xFFECECFB,
    true
  );

  @AnyLogicInternalCodegenAPI
  protected static final Color _chart_flu_BackgroundColor = new Color(
    0xFFECECFB,
    true
  );

  @AnyLogicInternalCodegenAPI
  protected static final Color _chart_covid_BackgroundColor = new Color(
    0xFFECECFB,
    true
  );

  @AnyLogicInternalCodegenAPI
  protected static final Color _plot_BackgroundColor = new Color(
    0xFFECECFB,
    true
  );

  @AnyLogicInternalCodegenAPI
  protected static final int _pauseButton1 = 1;

  @AnyLogicInternalCodegenAPI
  protected static final int _startButton1 = 2;

  @AnyLogicInternalCodegenAPI
  protected static final int _stopButton1 = 3;

  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox = 4;

  @AnyLogicInternalCodegenAPI
  protected static final int _slider = 5;

  @AnyLogicInternalCodegenAPI
  protected static final int _button1 = 6;

  @AnyLogicInternalCodegenAPI
  protected static final int _image3 = 7;

  @AnyLogicInternalCodegenAPI
  protected static final int _roundRectangle1 = 8;

  @AnyLogicInternalCodegenAPI
  protected static final int _roundRectangle = 9;

  @AnyLogicInternalCodegenAPI
  protected static final int _oval = 10;

  @AnyLogicInternalCodegenAPI
  protected static final int _oval1 = 11;

  @AnyLogicInternalCodegenAPI
  protected static final int _oval4 = 12;

  @AnyLogicInternalCodegenAPI
  protected static final int _text = 13;

  @AnyLogicInternalCodegenAPI
  protected static final int _text1 = 14;

  @AnyLogicInternalCodegenAPI
  protected static final int _text2 = 15;

  @AnyLogicInternalCodegenAPI
  protected static final int _line = 16;

  @AnyLogicInternalCodegenAPI
  protected static final int _line1 = 17;

  @AnyLogicInternalCodegenAPI
  protected static final int _text3 = 18;

  @AnyLogicInternalCodegenAPI
  protected static final int _line2 = 19;

  @AnyLogicInternalCodegenAPI
  protected static final int _line3 = 20;

  @AnyLogicInternalCodegenAPI
  protected static final int _text7 = 21;

  @AnyLogicInternalCodegenAPI
  protected static final int _line4 = 22;

  @AnyLogicInternalCodegenAPI
  protected static final int _text8 = 23;

  @AnyLogicInternalCodegenAPI
  protected static final int _text4 = 24;

  @AnyLogicInternalCodegenAPI
  protected static final int _text5 = 25;

  @AnyLogicInternalCodegenAPI
  protected static final int _text6 = 26;

  @AnyLogicInternalCodegenAPI
  protected static final int _text9 = 27;

  @AnyLogicInternalCodegenAPI
  protected static final int _text10 = 28;

  @AnyLogicInternalCodegenAPI
  protected static final int _text11 = 29;

  @AnyLogicInternalCodegenAPI
  protected static final int _line5 = 30;

  @AnyLogicInternalCodegenAPI
  protected static final int _text12 = 31;

  @AnyLogicInternalCodegenAPI
  protected static final int _text13 = 32;

  @AnyLogicInternalCodegenAPI
  protected static final int _line6 = 33;

  @AnyLogicInternalCodegenAPI
  protected static final int _text14 = 34;

  @AnyLogicInternalCodegenAPI
  protected static final int _text15 = 35;

  @AnyLogicInternalCodegenAPI
  protected static final int _text16 = 36;

  @AnyLogicInternalCodegenAPI
  protected static final int _text17 = 37;

  @AnyLogicInternalCodegenAPI
  protected static final int _text19 = 38;

  @AnyLogicInternalCodegenAPI
  protected static final int _text20 = 39;

  @AnyLogicInternalCodegenAPI
  protected static final int _dialogWindow1 = 40;

  @AnyLogicInternalCodegenAPI
  protected static final int _text18 = 41;

  @AnyLogicInternalCodegenAPI
  protected static final int _closeFileWindow = 42;

  @AnyLogicInternalCodegenAPI
  protected static final int _text21 = 43;

  @AnyLogicInternalCodegenAPI
  protected static final int _text22 = 44;

  @AnyLogicInternalCodegenAPI
  protected static final int _text23 = 45;

  @AnyLogicInternalCodegenAPI
  protected static final int _text24 = 46;

  @AnyLogicInternalCodegenAPI
  protected static final int _text25 = 47;

  @AnyLogicInternalCodegenAPI
  protected static final int _chart_flu = 48;

  @AnyLogicInternalCodegenAPI
  protected static final int _chart_covid = 49;

  @AnyLogicInternalCodegenAPI
  protected static final int _Severity = 50;

  @AnyLogicInternalCodegenAPI
  protected static final int _chart1 = 51;

  @AnyLogicInternalCodegenAPI
  protected static final int _Severity1 = 52;

  @AnyLogicInternalCodegenAPI
  protected static final int _plot = 53;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 54;

  /**
   * Top-level presentation group id
   */
  @AnyLogicInternalCodegenAPI
  protected static final int _presentation = 0;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  /**
   * Top-level icon group id
   */
  @AnyLogicInternalCodegenAPI
  protected static final int _icon = -1;

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction(int _shape, int index) {
    switch (_shape) {
      case _pauseButton1:
        {
          ShapeButton self = this.pauseButton1;
          pauseSimulation();
        }
        break;
      case _startButton1:
        {
          ShapeButton self = this.startButton1;
          runSimulation();
        }
        break;
      case _stopButton1:
        {
          ShapeButton self = this.stopButton1;
          saveResults();
          if (closeFileWindow.isVisible() == false) {
            getExperiment().stop();
          }
        }
        break;
      case _button1:
        {
          ShapeButton self = this.button1;
          this.closeFileWindow.setVisible(false);
          getExperiment().stop();
        }
        break;
      default:
        super.executeShapeControlAction(_shape, index);
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction(int _shape, int index, boolean value) {
    switch (_shape) {
      case _checkbox:
        set_quarantine(value);
        break;
      default:
        super.executeShapeControlAction(_shape, index, value);
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction(int _shape, int index, double value) {
    switch (_shape) {
      case _slider:
        set_masks(value);
        break;
      default:
        super.executeShapeControlAction(_shape, index, value);
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getShapeControlMinimum(int _shape, int index) {
    switch (_shape) {
      case _slider:
        return 0;
      default:
        return super.getShapeControlMinimum(_shape, index);
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getShapeControlMaximum(int _shape, int index) {
    switch (_shape) {
      case _slider:
        return 100;
      default:
        return super.getShapeControlMaximum(_shape, index);
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean getShapeControlDefaultValueBoolean(int _shape, int index) {
    switch (_shape) {
      case _checkbox:
        return quarantine;
      default:
        return super.getShapeControlDefaultValueBoolean(_shape, index);
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getShapeControlDefaultValueDouble(int _shape, int index) {
    switch (_shape) {
      case _slider:
        return masks;
      default:
        return super.getShapeControlDefaultValueDouble(_shape, index);
    }
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_flu_DataItem0Value() {
    return nSusceptibleFlu;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_flu_DataItem1Value() {
    return nExposedFlu;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_flu_DataItem2Value() {
    return nInfectiousFlu;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_flu_DataItem3Value() {
    return nClinicalFlu;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_flu_DataItem4Value() {
    return nAsymptomaticFlu;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_flu_DataItem5Value() {
    return nMildFlu;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_flu_DataItem6Value() {
    return nICUFlu;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_flu_DataItem7Value() {
    return nRecoveredFlu;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_flu_DataItem8Value() {
    return nDeceasedFlu;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_covid_DataItem0Value() {
    return nSusceptibleCovid;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_covid_DataItem1Value() {
    return nExposedCovid;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_covid_DataItem2Value() {
    return nAsymptomaticCovid;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_covid_DataItem3Value() {
    return nMildCovid;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_covid_DataItem4Value() {
    return nClinicalCovid;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_covid_DataItem5Value() {
    return nICUCovid;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_covid_DataItem6Value() {
    return nVentilatorCovid;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_covid_DataItem7Value() {
    return nRecoveredCovid;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_covid_DataItem8Value() {
    return nDeceasedCovid;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _Severity_DataItem0Value() {
    return nMildCovid;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _Severity_DataItem1Value() {
    return nICUCovid;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _Severity_DataItem2Value() {
    return nVentilatorCovid;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart1_DataItem0Value() {
    return (
      this.people.hospital_covid() +
      this.people.hospital_flu() -
      2 *
      this.people.double_hospital()
    );
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart1_DataItem1Value() {
    return capacityNHS;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _Severity1_DataItem0Value() {
    return nAsymptomaticFlu;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _Severity1_DataItem1Value() {
    return nICUFlu;
  }

  ShapeButton pauseButton1;
  ShapeButton startButton1;
  ShapeButton stopButton1;
  ShapeCheckBox checkbox;

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _slider_SetDynamicParams_xjal(ShapeSlider shape) {
    shape.setEnabled(true);
    shape.setRange(
      getShapeControlMinimum(_slider),
      getShapeControlMaximum(_slider)
    );
  }

  ShapeSlider slider;
  ShapeButton button1;
  BarChart chart_flu;
  BarChart chart_covid;
  PieChart Severity;
  BarChart chart1;
  PieChart Severity1;
  TimePlot plot;
  ShapeImage image3;
  ShapeRoundedRectangle roundRectangle1;
  ShapeRoundedRectangle roundRectangle;
  ShapeOval oval;
  ShapeOval oval1;
  ShapeOval oval4;
  ShapeText text;
  ShapeText text1;
  ShapeText text2;
  ShapeLine line;
  ShapeLine line1;
  ShapeText text3;
  ShapeLine line2;
  ShapeLine line3;
  ShapeText text7;
  ShapeLine line4;
  ShapeText text8;
  ShapeText text4;

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text5_SetDynamicParams_xjal(ShapeText shape) {
    shape.setText(nDeceasedCovid + nDeceasedFlu);
  }

  ShapeText text5;
  ShapeText text6;

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text9_SetDynamicParams_xjal(ShapeText shape) {
    shape.setText(this.people.twinfected());
  }

  ShapeText text9;
  ShapeText text10;
  ShapeText text11;
  ShapeLine line5;
  ShapeText text12;
  ShapeText text13;
  ShapeLine line6;

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text14_SetDynamicParams_xjal(ShapeText shape) {
    boolean _visible = (
        this.people.hospital_covid() +
        this.people.hospital_flu() -
        2 *
        this.people.double_hospital() >
        capacityNHS
      )
      ? true
      : false;

    shape.setVisible(_visible);
    if (_visible) {}
  }

  ShapeText text14;
  ShapeText text15;

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text16_SetDynamicParams_xjal(ShapeText shape) {
    shape.setText(this.getEngine().time());
  }

  ShapeText text16;
  ShapeText text17;

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text19_SetDynamicParams_xjal(ShapeText shape) {
    shape.setText(people.size());
  }

  ShapeText text19;
  ShapeText text20;
  ShapeRoundedRectangle dialogWindow1;
  ShapeText text18;
  ShapeGroup closeFileWindow;
  ShapeText text21;
  ShapeText text22;

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text23_SetDynamicParams_xjal(ShapeText shape) {
    shape.setText(slider.getMin());
  }

  ShapeText text23;

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text24_SetDynamicParams_xjal(ShapeText shape) {
    shape.setText(slider.getMax());
  }

  ShapeText text24;

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text25_SetDynamicParams_xjal(ShapeText shape) {
    shape.setText(slider.getValue());
  }

  ShapeText text25;

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    pauseButton1 =
      new ShapeButton(
        Main.this,
        true,
        310.0,
        20.0,
        110.0,
        40.0,
        _pauseButton1_Fill_Color,
        indigo,
        _pauseButton1_Font,
        "Pause"
      ) {
        @Override
        @AnyLogicInternalCodegenAPI
        public void action() {
          executeShapeControlAction(_pauseButton1, 0);
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = 2497856772001675182L;
      };
    startButton1 =
      new ShapeButton(
        Main.this,
        true,
        160.0,
        20.0,
        120.0,
        40.0,
        _startButton1_Fill_Color,
        indigo,
        _startButton1_Font,
        "Start"
      ) {
        @Override
        @AnyLogicInternalCodegenAPI
        public void action() {
          executeShapeControlAction(_startButton1, 0);
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = 2497856772001675182L;
      };
    stopButton1 =
      new ShapeButton(
        Main.this,
        true,
        20.0,
        20.0,
        110.0,
        40.0,
        _stopButton1_Fill_Color,
        indigo,
        _stopButton1_Font,
        "Stop"
      ) {
        @Override
        @AnyLogicInternalCodegenAPI
        public void action() {
          executeShapeControlAction(_stopButton1, 0);
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = 2497856772001675194L;
      };
    checkbox =
      new ShapeCheckBox(
        Main.this,
        true,
        50.0,
        680.0,
        130.0,
        30.0,
        lavender,
        controlDefault,
        _checkbox_Font,
        "Quarantine"
      ) {
        @Override
        @AnyLogicInternalCodegenAPI
        public void action() {
          executeShapeControlAction(_checkbox, 0, value);
        }

        @Override
        public void setValueToDefault() {
          setSelected(getShapeControlDefaultValueBoolean(_checkbox, 0));
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = 2497856749263119098L;
      };
    slider =
      new ShapeSlider(
        Main.this,
        true,
        150.0,
        710.0,
        170.0,
        30.0,
        transparent,
        false,
        getShapeControlMinimum(_slider),
        getShapeControlMaximum(_slider),
        ShapeControl.TYPE_DOUBLE
      ) {
        @Override
        public void updateDynamicProperties(boolean publicOnly) {
          _slider_SetDynamicParams_xjal(this);
          super.updateDynamicProperties(publicOnly);
        }

        @Override
        @AnyLogicInternalCodegenAPI
        public void action() {
          executeShapeControlAction(_slider, 0, value);
        }

        @Override
        public void setValueToDefault() {
          setValue(
            limit(
              getMin(),
              getShapeControlDefaultValueDouble(_slider, 0),
              getMax()
            )
          );
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = 2497856750542305195L;
      };
    button1 =
      new ShapeButton(
        Main.this,
        true,
        -30.0,
        17.0,
        81.0,
        23.0,
        white,
        indigo,
        _button1_Font,
        "OK"
      ) {
        @Override
        @AnyLogicInternalCodegenAPI
        public void action() {
          executeShapeControlAction(_button1, 0);
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = 2497856750521673662L;
      };
    image3 =
      new ShapeImage(
        Main.this,
        SHAPE_DRAW_2D3D,
        true,
        0.0,
        0.0,
        0.0,
        0.0,
        1500.0,
        800.0,
        "/abm_multiple_disease_spread/",
        new String[] { "File_000.jpeg" }
      );
    roundRectangle1 =
      new ShapeRoundedRectangle(
        true,
        10.0,
        60.0,
        0.0,
        black,
        white,
        1480.0,
        700.0,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    roundRectangle =
      new ShapeRoundedRectangle(
        true,
        30.0,
        90.0,
        0.0,
        null,
        _roundRectangle_Fill_Color,
        290.0,
        660.0,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    oval =
      new ShapeOval(
        SHAPE_DRAW_2D3D,
        true,
        220.0,
        340.0,
        0.0,
        0.0,
        yellow,
        yellow,
        5.0,
        5.0,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    oval1 =
      new ShapeOval(
        SHAPE_DRAW_2D3D,
        true,
        220.0,
        370.0,
        0.0,
        0.0,
        gold,
        gold,
        5.0,
        5.0,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    oval4 =
      new ShapeOval(
        SHAPE_DRAW_2D3D,
        true,
        220.0,
        400.0,
        0.0,
        0.0,
        red,
        red,
        5.0,
        5.0,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    text =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        250.0,
        330.0,
        0.0,
        0.0,
        black,
        "Mild",
        _text_Font,
        ALIGNMENT_LEFT
      );
    text1 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        250.0,
        360.0,
        0.0,
        0.0,
        black,
        "ICU",
        _text1_Font,
        ALIGNMENT_LEFT
      );
    text2 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        240.0,
        390.0,
        0.0,
        0.0,
        black,
        "Ventilator",
        _text2_Font,
        ALIGNMENT_LEFT
      );
    line =
      new ShapeLine(
        SHAPE_DRAW_2D3D,
        true,
        40.0,
        270.0,
        0.0,
        silver,
        260.0,
        0.0,
        0.0,
        1.0,
        10.0,
        LINE_STYLE_SOLID
      );
    line1 =
      new ShapeLine(
        SHAPE_DRAW_2D3D,
        true,
        50.0,
        470.0,
        0.0,
        silver,
        250.0,
        0.0,
        0.0,
        1.0,
        10.0,
        LINE_STYLE_SOLID
      );
    text3 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        40.0,
        280.0,
        0.0,
        0.0,
        black,
        "Severity ",
        _text3_Font,
        ALIGNMENT_LEFT
      );
    line2 =
      new ShapeLine(
        SHAPE_DRAW_2D3D,
        true,
        40.0,
        470.0,
        0.0,
        silver,
        260.0,
        0.0,
        0.0,
        1.0,
        10.0,
        LINE_STYLE_SOLID
      );
    line3 =
      new ShapeLine(
        SHAPE_DRAW_2D3D,
        true,
        40.0,
        660.0,
        0.0,
        silver,
        260.0,
        0.0,
        0.0,
        1.0,
        10.0,
        LINE_STYLE_SOLID
      );
    text7 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        40.0,
        480.0,
        0.0,
        0.0,
        black,
        "Health system impact",
        _text7_Font,
        ALIGNMENT_LEFT
      );
    line4 =
      new ShapeLine(
        SHAPE_DRAW_2D3D,
        true,
        40.0,
        110.0,
        0.0,
        silver,
        260.0,
        0.0,
        0.0,
        1.0,
        10.0,
        LINE_STYLE_SOLID
      );
    text8 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        40.0,
        120.0,
        0.0,
        0.0,
        black,
        "People ",
        _text8_Font,
        ALIGNMENT_LEFT
      );
    text4 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        40.0,
        160.0,
        0.0,
        0.0,
        black,
        "Total deaths:",
        _text4_Font,
        ALIGNMENT_LEFT
      );
    text5 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        140.0,
        160.0,
        0.0,
        0.0,
        black,
        "Mild",
        _text5_Font,
        ALIGNMENT_LEFT
      ) {
        @Override
        public void updateDynamicProperties(boolean publicOnly) {
          _text5_SetDynamicParams_xjal(this);
          super.updateDynamicProperties(publicOnly);
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = 2497856749195929514L;
      };
    text6 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        40.0,
        200.0,
        0.0,
        0.0,
        black,
        "Twinfected:",
        _text6_Font,
        ALIGNMENT_LEFT
      );
    text9 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        140.0,
        200.0,
        0.0,
        0.0,
        black,
        "",
        _text9_Font,
        ALIGNMENT_LEFT
      ) {
        @Override
        public void updateDynamicProperties(boolean publicOnly) {
          _text9_SetDynamicParams_xjal(this);
          super.updateDynamicProperties(publicOnly);
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = 2497856749196195518L;
      };
    text10 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        50.0,
        320.0,
        0.0,
        0.0,
        black,
        "Covid",
        _text10_Font,
        ALIGNMENT_LEFT
      );
    text11 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        50.0,
        410.0,
        0.0,
        0.0,
        black,
        "Flu",
        _text11_Font,
        ALIGNMENT_LEFT
      );
    line5 =
      new ShapeLine(
        SHAPE_DRAW_2D3D,
        true,
        450.0,
        110.0,
        0.0,
        silver,
        250.0,
        0.0,
        0.0,
        1.0,
        10.0,
        LINE_STYLE_SOLID
      );
    text12 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        450.0,
        120.0,
        0.0,
        0.0,
        black,
        "Influenza ",
        _text12_Font,
        ALIGNMENT_LEFT
      );
    text13 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        960.0,
        120.0,
        0.0,
        0.0,
        black,
        "SARS-COV-2 ",
        _text13_Font,
        ALIGNMENT_LEFT
      );
    line6 =
      new ShapeLine(
        SHAPE_DRAW_2D3D,
        true,
        960.0,
        110.0,
        0.0,
        silver,
        250.0,
        0.0,
        0.0,
        1.0,
        10.0,
        LINE_STYLE_SOLID
      );
    text14 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        170.0,
        580.0,
        0.0,
        0.0,
        red,
        "Hospital bed \r\nlimit exceeded!!!",
        _text14_Font,
        ALIGNMENT_LEFT
      ) {
        @Override
        public void updateDynamicProperties(boolean publicOnly) {
          _text14_SetDynamicParams_xjal(this);
          super.updateDynamicProperties(publicOnly);
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = 2497856749246609087L;
      };
    text15 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        40.0,
        250.0,
        0.0,
        0.0,
        black,
        "Total time: ",
        _text15_Font,
        ALIGNMENT_LEFT
      );
    text16 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        140.0,
        250.0,
        0.0,
        0.0,
        black,
        "text",
        _text16_Font,
        ALIGNMENT_LEFT
      ) {
        @Override
        public void updateDynamicProperties(boolean publicOnly) {
          _text16_SetDynamicParams_xjal(this);
          super.updateDynamicProperties(publicOnly);
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = 2497856749247378090L;
      };
    text17 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        260.0,
        250.0,
        0.0,
        0.0,
        black,
        "Days",
        _text17_Font,
        ALIGNMENT_LEFT
      );
    text19 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        220.0,
        160.0,
        0.0,
        0.0,
        black,
        "",
        _text19_Font,
        ALIGNMENT_LEFT
      ) {
        @Override
        public void updateDynamicProperties(boolean publicOnly) {
          _text19_SetDynamicParams_xjal(this);
          super.updateDynamicProperties(publicOnly);
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = 2497856750539502255L;
      };
    text20 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        210.0,
        160.0,
        0.0,
        0.0,
        black,
        "/",
        _text20_Font,
        ALIGNMENT_LEFT
      );
    dialogWindow1 =
      new ShapeRoundedRectangle(
        true,
        -178.0,
        -118.0,
        0.0,
        black,
        white,
        366.0,
        177.0,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
    text18 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        6.0,
        -82.0,
        0.0,
        0.0,
        indigo,
        "Results cannot be saved.\r\nPlease close the excel file\r\nand run the simulation again.",
        _text18_Font,
        ALIGNMENT_CENTER
      );
    text21 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        40.0,
        660.0,
        0.0,
        0.0,
        black,
        "Prevention measures",
        _text21_Font,
        ALIGNMENT_LEFT
      );
    text22 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        40.0,
        710.0,
        0.0,
        0.0,
        black,
        "Masks effectivity:",
        _text22_Font,
        ALIGNMENT_LEFT
      );
    text23 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        150.0,
        740.0,
        0.0,
        0.0,
        black,
        "min",
        _text23_Font,
        ALIGNMENT_LEFT
      ) {
        @Override
        public void updateDynamicProperties(boolean publicOnly) {
          _text23_SetDynamicParams_xjal(this);
          super.updateDynamicProperties(publicOnly);
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = 2497856750542582442L;
      };
    text24 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        320.0,
        740.0,
        0.0,
        0.0,
        black,
        "max",
        _text24_Font,
        ALIGNMENT_RIGHT
      ) {
        @Override
        public void updateDynamicProperties(boolean publicOnly) {
          _text24_SetDynamicParams_xjal(this);
          super.updateDynamicProperties(publicOnly);
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = 2497856750542582443L;
      };
    text25 =
      new ShapeText(
        SHAPE_DRAW_2D,
        true,
        235.0,
        740.0,
        0.0,
        0.0,
        black,
        "value",
        _text25_Font,
        ALIGNMENT_CENTER
      ) {
        @Override
        public void updateDynamicProperties(boolean publicOnly) {
          _text25_SetDynamicParams_xjal(this);
          super.updateDynamicProperties(publicOnly);
        }

        /**
         * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
         */
        @AnyLogicInternalCodegenAPI
        private static final long serialVersionUID = 2497856750542582446L;
      };
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
      List<DataItem> _items = new ArrayList<DataItem>(9);
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_chart_flu_DataItem0Value());
          }
        }
      );
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_chart_flu_DataItem1Value());
          }
        }
      );
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_chart_flu_DataItem2Value());
          }
        }
      );
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_chart_flu_DataItem3Value());
          }
        }
      );
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_chart_flu_DataItem4Value());
          }
        }
      );
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_chart_flu_DataItem5Value());
          }
        }
      );
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_chart_flu_DataItem6Value());
          }
        }
      );
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_chart_flu_DataItem7Value());
          }
        }
      );
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_chart_flu_DataItem8Value());
          }
        }
      );
      List<String> _titles = new ArrayList<String>(9);
      _titles.add("Flu_Susceptible");
      _titles.add("Flu_Exposed");
      _titles.add("Flu_Infectious");
      _titles.add("Flu_Clinical");
      _titles.add("Flu_Asymptomatic");
      _titles.add("Flu_Mild");
      _titles.add("Flu_ICU");
      _titles.add("Flu_Recovered");
      _titles.add("Flu_Deceased");
      List<Color> _colors = new ArrayList<Color>(9);
      _colors.add(lime);
      _colors.add(mediumOrchid);
      _colors.add(crimson);
      _colors.add(yellowGreen);
      _colors.add(violetRed);
      _colors.add(tomato);
      _colors.add(dodgerBlue);
      _colors.add(gold);
      _colors.add(black);
      chart_flu =
        new BarChart(
          Main.this,
          true,
          450.0,
          140.0,
          470.0,
          320.0,
          new Color(0xFFECECFB, true),
          null,
          50.0,
          30.0,
          390.0,
          150.0,
          white,
          black,
          black,
          110.0,
          Chart.SOUTH,
          Chart.NORTH,
          Chart.SCALE_AUTO,
          0,
          0,
          0.74,
          Chart.GRID_DEFAULT,
          darkGray,
          darkGray,
          _items,
          _titles,
          _colors
        );
    }
    {
      List<DataItem> _items = new ArrayList<DataItem>(9);
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_chart_covid_DataItem0Value());
          }
        }
      );
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_chart_covid_DataItem1Value());
          }
        }
      );
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_chart_covid_DataItem2Value());
          }
        }
      );
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_chart_covid_DataItem3Value());
          }
        }
      );
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_chart_covid_DataItem4Value());
          }
        }
      );
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_chart_covid_DataItem5Value());
          }
        }
      );
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_chart_covid_DataItem6Value());
          }
        }
      );
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_chart_covid_DataItem7Value());
          }
        }
      );
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_chart_covid_DataItem8Value());
          }
        }
      );
      List<String> _titles = new ArrayList<String>(9);
      _titles.add("Covid_Susceptible");
      _titles.add("Covid_Exposed");
      _titles.add("Covid_Asymptomatic");
      _titles.add("Covid_Mild");
      _titles.add("Covid_Clinical");
      _titles.add("Covid_ICU");
      _titles.add("Covid_Ventilator");
      _titles.add("Covid_Recovered");
      _titles.add("Covid_Deceased");
      List<Color> _colors = new ArrayList<Color>(9);
      _colors.add(lime);
      _colors.add(magenta);
      _colors.add(violetRed);
      _colors.add(tomato);
      _colors.add(coral);
      _colors.add(red);
      _colors.add(gray);
      _colors.add(dodgerBlue);
      _colors.add(black);
      chart_covid =
        new BarChart(
          Main.this,
          true,
          960.0,
          140.0,
          510.0,
          320.0,
          new Color(0xFFECECFB, true),
          null,
          50.0,
          30.0,
          430.0,
          160.0,
          white,
          black,
          black,
          100.0,
          Chart.SOUTH,
          Chart.NORTH,
          Chart.SCALE_AUTO,
          0,
          0,
          0.88,
          Chart.GRID_DEFAULT,
          darkGray,
          darkGray,
          _items,
          _titles,
          _colors
        );
    }
    {
      List<DataItem> _items = new ArrayList<DataItem>(3);
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_Severity_DataItem0Value());
          }
        }
      );
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_Severity_DataItem1Value());
          }
        }
      );
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_Severity_DataItem2Value());
          }
        }
      );
      List<String> _titles = new ArrayList<String>(3);
      _titles.add("Mild");
      _titles.add("ICU");
      _titles.add("Ventilator");
      List<Color> _colors = new ArrayList<Color>(3);
      _colors.add(yellow);
      _colors.add(gold);
      _colors.add(red);
      Severity =
        new PieChart(
          Main.this,
          true,
          90.0,
          280.0,
          100.0,
          110.0,
          null,
          null,
          20.0,
          30.0,
          50.0,
          50.0,
          white,
          null,
          black,
          60.0,
          Chart.NONE,
          _items,
          _titles,
          _colors
        );
    }
    {
      List<DataItem> _items = new ArrayList<DataItem>(2);
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_chart1_DataItem0Value());
          }
        }
      );
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_chart1_DataItem1Value());
          }
        }
      );
      List<String> _titles = new ArrayList<String>(2);
      _titles.add("beds taken");
      _titles.add("total beds");
      List<Color> _colors = new ArrayList<Color>(2);
      _colors.add(darkMagenta);
      _colors.add(peru);
      chart1 =
        new BarChart(
          Main.this,
          true,
          40.0,
          500.0,
          260.0,
          160.0,
          null,
          null,
          40.0,
          10.0,
          50.0,
          130.0,
          white,
          black,
          black,
          130.0,
          Chart.EAST,
          Chart.NORTH,
          Chart.SCALE_AUTO,
          0,
          0,
          1.0,
          Chart.GRID_DEFAULT,
          null,
          darkGray,
          _items,
          _titles,
          _colors
        );
    }
    {
      List<DataItem> _items = new ArrayList<DataItem>(2);
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_Severity1_DataItem0Value());
          }
        }
      );
      _items.add(
        new DataItem() {
          @Override
          public void update() {
            setValue(_Severity1_DataItem1Value());
          }
        }
      );
      List<String> _titles = new ArrayList<String>(2);
      _titles.add("Mild");
      _titles.add("ICU");
      List<Color> _colors = new ArrayList<Color>(2);
      _colors.add(yellow);
      _colors.add(gold);
      Severity1 =
        new PieChart(
          Main.this,
          true,
          90.0,
          360.0,
          100.0,
          110.0,
          null,
          null,
          20.0,
          30.0,
          50.0,
          50.0,
          white,
          null,
          black,
          60.0,
          Chart.NONE,
          _items,
          _titles,
          _colors
        );
    }
    {
      DataSet _item;
      List<DataSet> _items = new ArrayList<DataSet>(2);
      _items.add(_plot_expression0_dataSet_xjal);
      _items.add(_plot_expression1_dataSet_xjal);
      List<String> _titles = new ArrayList<String>(2);
      _titles.add("Infected Flu");
      _titles.add("Infected Covid");
      List<Chart2DPlot.Appearance> _appearances = new ArrayList<Chart2DPlot.Appearance>(
        2
      );
      _appearances.add(
        new Chart2DPlot.Appearance(
          red,
          true,
          Chart.INTERPOLATION_LINEAR,
          2,
          Chart.POINT_CIRCLE
        )
      );
      _appearances.add(
        new Chart2DPlot.Appearance(
          blue,
          true,
          Chart.INTERPOLATION_LINEAR,
          2,
          Chart.POINT_TRIANGLE
        )
      );
      plot =
        new TimePlot(
          Main.this,
          true,
          450.0,
          490.0,
          1020.0,
          260.0,
          new Color(0xFFECECFB, true),
          null,
          50.0,
          30.0,
          940.0,
          170.0,
          white,
          black,
          black,
          30.0,
          Chart.SOUTH,
          100,
          Chart.WINDOW_MOVES_WITH_TIME,
          null,
          Chart.SCALE_AUTO,
          0,
          0,
          Chart.GRID_DEFAULT,
          Chart.GRID_DEFAULT,
          darkGray,
          darkGray,
          _items,
          _titles,
          _appearances
        );
    }
    {
      closeFileWindow =
        new ShapeGroup(
          Main.this,
          SHAPE_DRAW_2D,
          true,
          200.0,
          190.0,
          0.0,
          0.0,
          dialogWindow1,
          text18,
          button1
        );
    }
    closeFileWindow.setVisible(false);
  }

  // Static initialization of persistent elements
  {
    _createPersistentElementsBP0_xjal();
  }

  ShapeTopLevelPresentationGroup presentation;
  ShapeGroup icon;

  @Override
  @AnyLogicInternalCodegenAPI
  public Object getPersistentShape(int _shape) {
    switch (_shape) {
      case _presentation:
        return presentation;
      case _icon:
        return icon;
      case _pauseButton1:
        return pauseButton1;
      case _startButton1:
        return startButton1;
      case _stopButton1:
        return stopButton1;
      case _checkbox:
        return checkbox;
      case _slider:
        return slider;
      case _button1:
        return button1;
      case _chart_flu:
        return chart_flu;
      case _chart_covid:
        return chart_covid;
      case _Severity:
        return Severity;
      case _chart1:
        return chart1;
      case _Severity1:
        return Severity1;
      case _plot:
        return plot;
      case _image3:
        return image3;
      case _roundRectangle1:
        return roundRectangle1;
      case _roundRectangle:
        return roundRectangle;
      case _oval:
        return oval;
      case _oval1:
        return oval1;
      case _oval4:
        return oval4;
      case _text:
        return text;
      case _text1:
        return text1;
      case _text2:
        return text2;
      case _line:
        return line;
      case _line1:
        return line1;
      case _text3:
        return text3;
      case _line2:
        return line2;
      case _line3:
        return line3;
      case _text7:
        return text7;
      case _line4:
        return line4;
      case _text8:
        return text8;
      case _text4:
        return text4;
      case _text5:
        return text5;
      case _text6:
        return text6;
      case _text9:
        return text9;
      case _text10:
        return text10;
      case _text11:
        return text11;
      case _line5:
        return line5;
      case _text12:
        return text12;
      case _text13:
        return text13;
      case _line6:
        return line6;
      case _text14:
        return text14;
      case _text15:
        return text15;
      case _text16:
        return text16;
      case _text17:
        return text17;
      case _text19:
        return text19;
      case _text20:
        return text20;
      case _dialogWindow1:
        return dialogWindow1;
      case _text18:
        return text18;
      case _closeFileWindow:
        return closeFileWindow;
      case _text21:
        return text21;
      case _text22:
        return text22;
      case _text23:
        return text23;
      case _text24:
        return text24;
      case _text25:
        return text25;
      default:
        return super.getPersistentShape(_shape);
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOfShape_xjal(Object _shape) {
    try {
      if (_shape == null) return null;
      String _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, presentation, "presentation");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, icon, "icon");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, pauseButton1, "pauseButton1");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, startButton1, "startButton1");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, stopButton1, "stopButton1");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, checkbox, "checkbox");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, slider, "slider");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, button1, "button1");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, chart_flu, "chart_flu");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, chart_covid, "chart_covid");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, Severity, "Severity");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, chart1, "chart1");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, Severity1, "Severity1");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, plot, "plot");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, image3, "image3");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(_shape, roundRectangle1, "roundRectangle1");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(_shape, roundRectangle, "roundRectangle");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, oval, "oval");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, oval1, "oval1");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, oval4, "oval4");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text, "text");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text1, "text1");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text2, "text2");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, line, "line");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, line1, "line1");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text3, "text3");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, line2, "line2");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, line3, "line3");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text7, "text7");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, line4, "line4");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text8, "text8");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text4, "text4");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text5, "text5");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text6, "text6");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text9, "text9");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text10, "text10");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text11, "text11");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, line5, "line5");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text12, "text12");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text13, "text13");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, line6, "line6");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text14, "text14");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text15, "text15");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text16, "text16");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text17, "text17");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text19, "text19");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text20, "text20");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(_shape, dialogWindow1, "dialogWindow1");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text18, "text18");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal =
        checkNameOfShape_xjal(_shape, closeFileWindow, "closeFileWindow");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text21, "text21");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text22, "text22");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text23, "text23");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text24, "text24");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, text25, "text25");
      if (_name_xjal != null) return _name_xjal;
    } catch (Exception e) {
      return null;
    }
    return super.getNameOfShape_xjal(_shape);
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Connectivity_xjal(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly) {
      drawExcelFile(_panel, _g, -700, 560, 10, 0, "resultsFile", resultsFile);
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Events_xjal(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly) {
      drawEvent(_panel, _g, -820, 40, 10, 0, "infectFlu", infectFlu);
    }
    if (!_publicOnly) {
      drawEvent(_panel, _g, -820, 70, 10, 0, "infectCovid", infectCovid);
    }
    if (!_publicOnly) {
      drawEvent(_panel, _g, -830, 100, 10, 0, "endSimulation", endSimulation);
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Parameters_xjal(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly) {
      drawParameter(_panel, _g, -700, 420, 10, 0, "duration", duration, 0);
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Functions_xjal(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly) {
      drawFunction(_panel, _g, -700, 530, 10, 0, "saveResults");
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void drawModelElements(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    super.drawModelElements(_panel, _g, _publicOnly, true);
    drawModelElements_Connectivity_xjal(_panel, _g, _publicOnly, _isSuperClass);
    drawModelElements_Events_xjal(_panel, _g, _publicOnly, _isSuperClass);
    drawModelElements_Parameters_xjal(_panel, _g, _publicOnly, _isSuperClass);
    drawModelElements_Functions_xjal(_panel, _g, _publicOnly, _isSuperClass);
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_Connectivity_xjal(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly && modelElementContains(_x, _y, -700, 560)) {
      _panel.addInspect(-700, 560, this, "resultsFile");
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_Parameters_xjal(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly && modelElementContains(_x, _y, -700, 420)) {
      _panel.addInspect(-700, 420, this, "duration");
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_Events_xjal(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly && modelElementContains(_x, _y, -820, 40)) {
      _panel.addInspect(-820, 40, this, "infectFlu");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -820, 70)) {
      _panel.addInspect(-820, 70, this, "infectCovid");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -830, 100)) {
      _panel.addInspect(-830, 100, this, "endSimulation");
      return true;
    }
    return false;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onClickModelAt(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (
      onClickModelAt_Connectivity_xjal(
        _panel,
        _x,
        _y,
        _clickCount,
        _publicOnly,
        _isSuperClass
      )
    ) {
      return true;
    }
    if (
      onClickModelAt_Parameters_xjal(
        _panel,
        _x,
        _y,
        _clickCount,
        _publicOnly,
        _isSuperClass
      )
    ) {
      return true;
    }
    if (
      onClickModelAt_Events_xjal(
        _panel,
        _x,
        _y,
        _clickCount,
        _publicOnly,
        _isSuperClass
      )
    ) {
      return true;
    }
    return super.onClickModelAt(_panel, _x, _y, _clickCount, _publicOnly, true);
  }

  /**
   * Constructor
   */
  public Main(
    Engine engine,
    Agent owner,
    AgentList<? extends Main> collection
  ) {
    super(engine, owner, collection);
    if (isTopLevelClass_xjal(Main.class)) {
      instantiateBaseStructure_xjal();
    }
  }

  @AnyLogicInternalCodegenAPI
  public void onOwnerChanged_xjal() {
    super.onOwnerChanged_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void instantiateBaseStructure_xjal() {
    super.instantiateBaseStructure_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {}

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Main() {}

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Main(
    int numHospitals,
    int numHomes,
    int numMarkets,
    int numSchools,
    int numWorkplaces,
    int numPeople,
    int startCovid,
    int startFlu,
    boolean quarantine,
    double masks,
    double duration
  ) {
    markParametersAreSet();
    this.numHospitals = numHospitals;
    this.numHomes = numHomes;
    this.numMarkets = numMarkets;
    this.numSchools = numSchools;
    this.numWorkplaces = numWorkplaces;
    this.numPeople = numPeople;
    this.startCovid = startCovid;
    this.startFlu = startFlu;
    this.quarantine = quarantine;
    this.masks = masks;
    this.duration = duration;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void create() {
    super.create();
    // Creating embedded object instances
    {
      int _cnt = numHomes;
      for (int i = 0; i < _cnt; i++) {
        instantiate_homes_xjal(i);
      }
    }
    {
      int _cnt = numHospitals;
      for (int i = 0; i < _cnt; i++) {
        instantiate_hospitals_xjal(i);
      }
    }
    {
      int _cnt = numMarkets;
      for (int i = 0; i < _cnt; i++) {
        instantiate_markets_xjal(i);
      }
    }
    {
      int _cnt = 0;
      for (int i = 0; i < _cnt; i++) {
        instantiate_people_xjal(i);
      }
    }
    {
      int _cnt = numSchools;
      for (int i = 0; i < _cnt; i++) {
        instantiate_schools_xjal(i);
      }
    }
    {
      int _cnt = numWorkplaces;
      for (int i = 0; i < _cnt; i++) {
        instantiate_workplaces_xjal(i);
      }
    }
    // Assigning initial values for plain variables
    setupPlainVariables_Main_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
    presentation =
      new ShapeTopLevelPresentationGroup(
        Main.this,
        true,
        0,
        0,
        0,
        0,
        image3,
        roundRectangle1,
        roundRectangle,
        oval,
        oval1,
        oval4,
        text,
        text1,
        text2,
        line,
        line1,
        text3,
        line2,
        line3,
        text7,
        line4,
        text8,
        text4,
        text5,
        text6,
        text9,
        text10,
        text11,
        line5,
        text12,
        text13,
        line6,
        text14,
        text15,
        text16,
        text17,
        text19,
        text20,
        closeFileWindow,
        text21,
        text22,
        text23,
        text24,
        text25,
        pauseButton1,
        startButton1,
        stopButton1,
        checkbox,
        slider,
        chart_flu,
        chart_covid,
        Severity,
        chart1,
        Severity1,
        plot
      );
    icon = new ShapeGroup(Main.this, true, 0, 0, 0);
    // Environments setup
    {
      double _x_xjal = 1500;
      double _y_xjal = 800;
      double _z_xjal = 0;
      setupSpace(_x_xjal, _y_xjal, _z_xjal);
    }
    disableSteps();
    {
      double _v1_xjal = 0;
      setNetworkRandom(_v1_xjal);
    }
    setLayoutType(LAYOUT_RANDOM);
    // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    homes.setEnvironment(this);
    for (int i = 0; i < homes.size(); i++) {
      setupParameters_homes_xjal(homes.get(i), i);
      create_homes_xjal(homes.get(i), i);
    }
    hospitals.setEnvironment(this);
    for (int i = 0; i < hospitals.size(); i++) {
      setupParameters_hospitals_xjal(hospitals.get(i), i);
      create_hospitals_xjal(hospitals.get(i), i);
    }
    markets.setEnvironment(this);
    for (int i = 0; i < markets.size(); i++) {
      setupParameters_markets_xjal(markets.get(i), i);
      create_markets_xjal(markets.get(i), i);
    }
    people.setEnvironment(this);
    for (int i = 0; i < people.size(); i++) {
      setupParameters_people_xjal(people.get(i), i);
      create_people_xjal(people.get(i), i);
    }
    schools.setEnvironment(this);
    for (int i = 0; i < schools.size(); i++) {
      setupParameters_schools_xjal(schools.get(i), i);
      create_schools_xjal(schools.get(i), i);
    }
    workplaces.setEnvironment(this);
    for (int i = 0; i < workplaces.size(); i++) {
      setupParameters_workplaces_xjal(workplaces.get(i), i);
      create_workplaces_xjal(workplaces.get(i), i);
    }
    setupInitialConditions_xjal(Main.class);
    checkbox.setValueToDefault();
    slider.setValueToDefault();
    if (isTopLevelClass_xjal(Main.class)) {
      onCreate();
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void start() {
    super.start();
    infectFlu.start();
    infectCovid.start();
    endSimulation.start();
    _covidDead_autoUpdateEvent_xjal.start();
    _fluDead_autoUpdateEvent_xjal.start();
    _nHospitalizedStat_autoUpdateEvent_xjal.start();
    _covidSusceptible_autoUpdateEvent_xjal.start();
    _covidExposed_autoUpdateEvent_xjal.start();
    _covidClinical_autoUpdateEvent_xjal.start();
    _covidMild_autoUpdateEvent_xjal.start();
    _covidVentilator_autoUpdateEvent_xjal.start();
    _covidICU_autoUpdateEvent_xjal.start();
    _covidRecovered_autoUpdateEvent_xjal.start();
    _fluSusceptible_autoUpdateEvent_xjal.start();
    _fluExposed_autoUpdateEvent_xjal.start();
    _fluRecovered_autoUpdateEvent_xjal.start();
    _fluInfectious_autoUpdateEvent_xjal.start();
    _fluClinical_autoUpdateEvent_xjal.start();
    _fluICU_autoUpdateEvent_xjal.start();
    _fluAsymptomatic_autoUpdateEvent_xjal.start();
    _covidInfectious_autoUpdateEvent_xjal.start();
    _fluMild_autoUpdateEvent_xjal.start();
    _covidAsymptomatic_autoUpdateEvent_xjal.start();
    _chart_flu_autoUpdateEvent_xjal.start();
    _chart_covid_autoUpdateEvent_xjal.start();
    _Severity_autoUpdateEvent_xjal.start();
    _chart1_autoUpdateEvent_xjal.start();
    _Severity1_autoUpdateEvent_xjal.start();
    _plot_autoUpdateEvent_xjal.start();
    applyLayout();
    for (Agent embeddedObject : homes) {
      embeddedObject.start();
    }
    for (Agent embeddedObject : hospitals) {
      embeddedObject.start();
    }
    for (Agent embeddedObject : markets) {
      embeddedObject.start();
    }
    for (Agent embeddedObject : people) {
      embeddedObject.start();
    }
    for (Agent embeddedObject : schools) {
      embeddedObject.start();
    }
    for (Agent embeddedObject : workplaces) {
      embeddedObject.start();
    }
    if (isTopLevelClass_xjal(Main.class)) {
      onStartup();
    }
  }

  @AnyLogicInternalCodegenAPI
  public void onStartup() {
    super.onStartup();

    //setup families
    for (int i = 0; i < numHomes; i++) {
      //create a Home object
      Home h = add_homes();
      //set home location
      //add family members
      int size = uniform_discr(2, 5);
      for (int j = 0; j < size; j++) {
        //create a person
        Person p = add_people();
        //add to the family
        h.members.add(p);
        p.agentHome = h;
        //set its home location (in family house)
        p.jumpTo(p.agentHome.getX(), p.agentHome.getY());
        //assign school
        if (p.agentAge > 3 && p.agentAge < 19) {
          School s = schools.get(uniform_discr(0, schools.size() - 1));
          p.agentSchool = s;
          p.agentWorkplace = null;
        }
        //assign work
        else if (p.agentAge >= 19 && p.agentAge < 65) {
          Workplace work = workplaces.get(
            uniform_discr(0, workplaces.size() - 1)
          );
          p.agentWorkplace = work;
          p.agentSchool = null;
        }
        //set social place
        SocialPlace m = p.getNearestAgent(markets);
        p.agentMarket = m;
        //set nearest hospital in case of emergency
        Hospital hosp = p.getNearestAgent(hospitals);
        p.nearestHospital = hosp;
      }
    }
    for (int i = 0; i < numHospitals; i++) {
      capacityNHS += hospitals.get(i).capacity;
    }

    observatoryViewArea.navigateTo();

    try {
      resultsFile.readFile();
    } catch (RuntimeException e) {
      System.out.println("close it");
    }
    if (duration == 0) {
      this.endSimulation.suspend();
    }
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_Main_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_Main_xjal() {
    nDeceasedCovid = 0;
    nDeceasedFlu = 0;
    nHospitalized = 0;
    nSusceptibleCovid = 0;
    nExposedCovid = 0;
    nClinicalCovid = 0;
    nMildCovid = 0;
    nICUCovid = 0;
    nVentilatorCovid = 0;
    nRecoveredCovid = 0;
    nSusceptibleFlu = 0;
    nExposedFlu = 0;
    nRecoveredFlu = 0;
    nInfectiousFlu = 0;
    capacityNHS = 0;
    nClinicalFlu = 0;
    nICUFlu = 0;
    nAsymptomaticFlu = 0;
    nInfectiousCovid = 0;
    nMildFlu = 0;
    nAsymptomaticCovid = 0;
  }

  // User API -----------------------------------------------------
  @AnyLogicInternalCodegenAPI
  static LinkToAgentAnimationSettings _connections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl(
    false,
    black,
    1.0,
    LINE_STYLE_SOLID,
    ARROW_NONE,
    0.0
  );

  public LinkToAgentCollection<Agent, Agent> connections = new LinkToAgentStandardImpl<Agent, Agent>(
    this,
    _connections_commonAnimationSettings_xjal
  );

  @Override
  public LinkToAgentCollection<? extends Agent, ? extends Agent> getLinkToAgentStandard_xjal() {
    return connections;
  }

  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(
    boolean _underAgents_xjal,
    LinkToAgentAnimator _animator_xjal
  ) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if (_underAgents_xjal) {
      _animator_xjal.drawLink(this, connections, true, true);
    }
  }

  public List<Object> getEmbeddedObjects() {
    List<Object> list = super.getEmbeddedObjects();
    if (list == null) {
      list = new LinkedList<Object>();
    }
    list.add(homes);
    list.add(hospitals);
    list.add(markets);
    list.add(people);
    list.add(schools);
    list.add(workplaces);
    return list;
  }

  public AgentList<? extends Main> getPopulation() {
    return (AgentList<? extends Main>) super.getPopulation();
  }

  public List<? extends Main> agentsInRange(double distance) {
    return (List<? extends Main>) super.agentsInRange(distance);
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    infectFlu.onDestroy();
    infectCovid.onDestroy();
    endSimulation.onDestroy();
    _covidDead_autoUpdateEvent_xjal.onDestroy();
    _fluDead_autoUpdateEvent_xjal.onDestroy();
    _nHospitalizedStat_autoUpdateEvent_xjal.onDestroy();
    _covidSusceptible_autoUpdateEvent_xjal.onDestroy();
    _covidExposed_autoUpdateEvent_xjal.onDestroy();
    _covidClinical_autoUpdateEvent_xjal.onDestroy();
    _covidMild_autoUpdateEvent_xjal.onDestroy();
    _covidVentilator_autoUpdateEvent_xjal.onDestroy();
    _covidICU_autoUpdateEvent_xjal.onDestroy();
    _covidRecovered_autoUpdateEvent_xjal.onDestroy();
    _fluSusceptible_autoUpdateEvent_xjal.onDestroy();
    _fluExposed_autoUpdateEvent_xjal.onDestroy();
    _fluRecovered_autoUpdateEvent_xjal.onDestroy();
    _fluInfectious_autoUpdateEvent_xjal.onDestroy();
    _fluClinical_autoUpdateEvent_xjal.onDestroy();
    _fluICU_autoUpdateEvent_xjal.onDestroy();
    _fluAsymptomatic_autoUpdateEvent_xjal.onDestroy();
    _covidInfectious_autoUpdateEvent_xjal.onDestroy();
    _fluMild_autoUpdateEvent_xjal.onDestroy();
    _covidAsymptomatic_autoUpdateEvent_xjal.onDestroy();
    _chart_flu_autoUpdateEvent_xjal.onDestroy();
    _chart_covid_autoUpdateEvent_xjal.onDestroy();
    _Severity_autoUpdateEvent_xjal.onDestroy();
    _chart1_autoUpdateEvent_xjal.onDestroy();
    _Severity1_autoUpdateEvent_xjal.onDestroy();
    _plot_autoUpdateEvent_xjal.onDestroy();
    for (Agent _item : homes) {
      _item.onDestroy();
    }
    for (Agent _item : hospitals) {
      _item.onDestroy();
    }
    for (Agent _item : markets) {
      _item.onDestroy();
    }
    for (Agent _item : people) {
      _item.onDestroy();
    }
    for (Agent _item : schools) {
      _item.onDestroy();
    }
    for (Agent _item : workplaces) {
      _item.onDestroy();
    }
    // Analysis Data Elements
    _plot_expression0_dataSet_xjal.destroyUpdater_xjal();
    _plot_expression1_dataSet_xjal.destroyUpdater_xjal();
    covidDead.destroyUpdater_xjal();
    fluDead.destroyUpdater_xjal();
    nHospitalizedStat.destroyUpdater_xjal();
    covidSusceptible.destroyUpdater_xjal();
    covidExposed.destroyUpdater_xjal();
    covidClinical.destroyUpdater_xjal();
    covidMild.destroyUpdater_xjal();
    covidVentilator.destroyUpdater_xjal();
    covidICU.destroyUpdater_xjal();
    covidRecovered.destroyUpdater_xjal();
    fluSusceptible.destroyUpdater_xjal();
    fluExposed.destroyUpdater_xjal();
    fluRecovered.destroyUpdater_xjal();
    fluInfectious.destroyUpdater_xjal();
    fluClinical.destroyUpdater_xjal();
    fluICU.destroyUpdater_xjal();
    fluAsymptomatic.destroyUpdater_xjal();
    twinfectedDS.destroyUpdater_xjal();
    covidInfectious.destroyUpdater_xjal();
    fluMild.destroyUpdater_xjal();
    covidAsymptomatic.destroyUpdater_xjal();
    super.onDestroy();
  }

  /**
   * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
   */
  @AnyLogicInternalCodegenAPI
  private static final long serialVersionUID = 2497856770922702590L;
}
